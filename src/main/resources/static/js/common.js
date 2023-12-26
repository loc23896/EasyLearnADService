window.addEventListener("load", function () {
    const loginForm = document.querySelector(".login-form");
    const showPasswordIcon =
        loginForm && loginForm.querySelector(".show-password");
    const inputPassword =
        loginForm && loginForm.querySelector('input[type="password"');
    showPasswordIcon.addEventListener("click", function () {
        const inputPasswordType = inputPassword.getAttribute("type");
        inputPasswordType === "password"
            ? inputPassword.setAttribute("type", "text")
            : inputPassword.setAttribute("type", "password");
            if (username === '' || password === '' || phone === '' || address === '') {
                alert("Vui lòng điền đầy đủ thông tin");
                return;
              }
                
              // Validate độ dài số điện thoại
              if (phone.length !== 9) {
                alert("Số điện thoại phải có 9 chữ số");
                return;
              }
    });
});