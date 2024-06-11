import React, { useState, useEffect } from "react";
import axios from "axios";

const AddProduct = () => {
  const [product, setProduct] = useState({
    name: "",
    listedPrice: "",
    sellingPrice: "",
    description: "",
    stock: "",
    brandId: "",
    categoryIds: [],
    newProductImages: [],
  });

  const [brands, setBrands] = useState([]);
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    const fetchBrandsAndCategories = async () => {
      try {
        const [brandsResponse, categoriesResponse] = await Promise.all([
          axios.get("http://localhost:8010/api/brands"),
          axios.get("http://localhost:8010/api/categories"),
        ]);
        setBrands(brandsResponse.data);
        setCategories(categoriesResponse.data);
      } catch (error) {
        console.error("Error fetching brands and categories", error);
      }
    };
    fetchBrandsAndCategories();
  }, []);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setProduct((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  const handleMultiSelectChange = (e) => {
    const { name, selectedOptions } = e.target;
    const values = Array.from(selectedOptions).map((option) => option.value);
    setProduct((prevState) => ({
      ...prevState,
      [name]: values,
    }));
  };

  const handleFileChange = (e) => {
    setProduct((prevState) => ({
      ...prevState,
      newProductImages: e.target.files,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const formData = new FormData();
    formData.append("name", product.name);
    formData.append("listedPrice", product.listedPrice);
    formData.append("sellingPrice", product.sellingPrice);
    formData.append("description", product.description);
    formData.append("stock", product.stock);
    formData.append("brandId", product.brandId);
    product.categoryIds.forEach((id) => formData.append("categoryIds", id));
    Array.from(product.newProductImages).forEach((file) => {
      formData.append("newProductImages", file);
    });

    try {
      const response = await axios.post("http://localhost:8010/api/products", formData, {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      });
      console.log("Product added successfully", response.data);
    } catch (error) {
      console.error("There was an error uploading the product!", error);
    }
  };

  return (
    <div>
      <h2>Add Product</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Name:</label>
          <input type="text" name="name" value={product.name} onChange={handleChange} required />
        </div>
        <div>
          <label>Listed Price:</label>
          <input
            type="number"
            name="listedPrice"
            value={product.listedPrice}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>Selling Price:</label>
          <input
            type="number"
            name="sellingPrice"
            value={product.sellingPrice}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>Description:</label>
          <textarea
            name="description"
            value={product.description}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>Stock:</label>
          <input
            type="number"
            name="stock"
            value={product.stock}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>Brand:</label>
          <select name="brandId" value={product.brandId} onChange={handleChange} required>
            <option value="">Select a brand</option>
            {brands.map((brand) => (
              <option key={brand.brandId} value={brand.brandId}>
                {brand.name}
              </option>
            ))}
          </select>
        </div>
        <div>
          <label>Categories:</label>
          <select
            name="categoryIds"
            multiple={true}
            value={product.categoryIds}
            onChange={handleMultiSelectChange}
            required
          >
            {categories.map((category) => (
              <option key={category.categoryId} value={category.categoryId}>
                {category.name}
              </option>
            ))}
          </select>
        </div>
        <div>
          <label>Images:</label>
          <input type="file" name="newProductImages" multiple onChange={handleFileChange} />
        </div>
        <button type="submit">Add Product</button>
      </form>
    </div>
  );
};

export default AddProduct;
