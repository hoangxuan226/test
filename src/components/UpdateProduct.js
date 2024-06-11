import React, { useEffect, useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";

function UpdateProductForm() {
  const { productId } = useParams();
  const [product, setProduct] = useState({
    name: "",
    listedPrice: "",
    sellingPrice: "",
    description: "",
    stock: "",

    // received data
    brand: "",
    categories: [],
    productImages: [], // array current [{imageId, imagePath}]

    // data to send
    brandId: "",
    categoryIds: [],
    newImageFiles: [], // new images to upload (MultipartFile[])
    imageProductIds: [], // array of image IDs to delete
  });

  const [brands, setBrands] = useState([]);
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    let isMounted = true; // Track mounted status

    const fetchData = async () => {
      try {
        const productDetailsUrl = `http://localhost:8010/api/products/${productId}`;
        const brandsUrl = "http://localhost:8010/api/brands";
        const categoriesUrl = "http://localhost:8010/api/categories";

        const [productDetails, brands, categories] = await Promise.all([
          axios.get(productDetailsUrl),
          axios.get(brandsUrl),
          axios.get(categoriesUrl),
        ]);

        if (isMounted) {
          setProduct((prevState) => ({
            ...prevState, // Spread the existing state to preserve other properties
            ...productDetails.data, // Spread the new data which may overwrite some properties from the state
            brandId: productDetails.data.brand.brandId,
            categoryIds: productDetails.data.categories.map((category) => category.categoryId),
          }));
          setBrands(brands.data);
          setCategories(categories.data);
        }
      } catch (error) {
        console.error("There was an error fetching the data!", error);
      }
    };

    fetchData();

    return () => {
      isMounted = false; // Cleanup function to avoid setting state on unmounted component
    };
  }, [productId]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setProduct((prevState) => ({ ...prevState, [name]: value }));
  };

  const handleCategoryChange = (e) => {
    const { options } = e.target;
    const selectedCategories = [];
    for (let i = 0, l = options.length; i < l; i++) {
      if (options[i].selected) {
        selectedCategories.push(options[i].value);
      }
    }
    setProduct((prevState) => ({ ...prevState, categoryIds: selectedCategories }));
  };

  const handleFileChange = (e) => {
    setProduct((prevState) => ({ ...prevState, newImageFiles: e.target.files }));
  };

  const handleCheckboxChange = (imageId, isChecked) => {
    setProduct((prevProduct) => {
      const newimageProductIds = isChecked
        ? [...prevProduct.imageProductIds, imageId]
        : prevProduct.imageProductIds.filter((id) => id !== imageId);
      return { ...prevProduct, imageProductIds: newimageProductIds };
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const formData = new FormData();
    formData.append("productId", productId);
    formData.append("name", product.name);
    formData.append("listedPrice", product.listedPrice);
    formData.append("sellingPrice", product.sellingPrice);
    formData.append("description", product.description);
    formData.append("stock", product.stock);
    formData.append("brandId", product.brandId);
    product.categoryIds.forEach((id) => formData.append("categoryIds", id));
    Array.from(product.newImageFiles).forEach((file) => formData.append("newImageFiles", file));
    product.imageProductIds.forEach((id) => formData.append("imageProductIds", id));

    axios
      .put(`http://localhost:8010/api/products/${productId}`, formData, {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      })
      .then((response) => {
        console.log("Product updated successfully!", response.data);
        // Handle success (e.g., redirect or show success message)
      })
      .catch((error) => {
        console.error("There was an error updating the product!", error);
        // Handle error
      });
  };

  useEffect(() => {
    console.log(product); // Logging the updated product state
  }, [product]);

  return (
    <>
      <form onSubmit={handleSubmit}>
        <label>Name:</label>
        <input type="text" name="name" value={product.name} onChange={handleChange} />

        <label>Listed Price:</label>
        <input
          type="number"
          name="listedPrice"
          value={product.listedPrice}
          onChange={handleChange}
        />

        <label>Selling Price:</label>
        <input
          type="number"
          name="sellingPrice"
          value={product.sellingPrice}
          onChange={handleChange}
        />

        <label>Description:</label>
        <textarea name="description" value={product.description} onChange={handleChange}></textarea>

        <label>Stock:</label>
        <input type="number" name="stock" value={product.stock} onChange={handleChange} />

        <label>Brand:</label>
        <select name="brandId" value={product.brandId} onChange={handleChange}>
          {brands.map((brand) => (
            <option key={brand.brandId} value={brand.brandId}>
              {brand.name}
            </option>
          ))}
        </select>

        <label>Categories:</label>
        <select
          multiple={true}
          name="categoryIds"
          value={product.categoryIds.map((id) => String(id))}
          onChange={handleCategoryChange}
        >
          {categories.map((category) => (
            <option key={category.categoryId} value={category.categoryId}>
              {category.name}
            </option>
          ))}
        </select>

        <div>
          <label>Product Images:</label>
          <input type="file" name="newImageFiles" multiple onChange={handleFileChange} />
          <div>
            {/* Display old images and checkboxes to delete */}
            {product.productImages.map((image) => (
              <div key={image.imageId}>
                <img
                  src={`http://localhost:8010/images/products/${image.imagePath}`}
                  alt=""
                  style={{ width: "150px", height: "auto" }}
                />
                <input
                  checked
                  type="checkbox"
                  name={`keepImage-${image.imageId}`}
                  onChange={(e) => handleCheckboxChange(image.imageId, e.target.checked)}
                />
                <label htmlFor={`keepImage-${image.imageId}`}>Keep</label>
              </div>
            ))}
          </div>
        </div>
        <button type="submit">Update Product</button>
      </form>
    </>
  );
}

export default UpdateProductForm;
