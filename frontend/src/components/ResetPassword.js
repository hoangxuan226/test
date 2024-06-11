import React, { useEffect } from "react";
import backgroundImage from "../images/backgroundDemo.jpg";
import "../loginAndRegister.css";

export default function ResetPassword() {
  useEffect(() => {
    // Set class and background image for the body
    document.body.classList.add("img");
    document.body.classList.add("js-fullheight");
    document.body.style.backgroundImage = `url(${backgroundImage})`;

    // Cleanup function to remove added class and background image
    return () => {
      document.body.classList.remove("img");
      document.body.classList.remove("js-fullheight");
      document.body.style.backgroundImage = "none";
    };
  }, []);
  return (
    <div class="ftco-section-forgot-pwd">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-md-6 col-lg-4">
            <div class="login-wrap p-0">
              <h3 class="mb-4 text-center">Đổi mật khẩu</h3>
              <form action="#" class="signin-form">
                <div class="form-group">
                  <input type="text" class="form-control" placeholder="Nhập Gmail" required />
                </div>

                <div class="form-group">
                  <button type="submit" class="form-control btn btn-primary submit px-3">
                    Xác nhận
                  </button>
                </div>
              </form>
              <p class="w-100 text-center">&mdash; Quay lại trang &mdash;</p>
              <div class="form-group row text-center">
                <div class="forgot-pwd col-md-6 border-right">
                  <a href="/login" style={{ color: "#fff" }}>
                    Đăng nhập
                  </a>
                </div>
                <div class="forgot-pwd col-md-6">
                  <a href="/register" style={{ color: "#fff" }}>
                    Đăng kí
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
