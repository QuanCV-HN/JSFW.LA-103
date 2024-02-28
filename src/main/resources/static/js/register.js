window.onload = function () {
    var inputUser = document.getElementById('user');
    var errUser = document.getElementById('errUser');

    var inputEmail = document.getElementById('email');
    var errEmail = document.getElementById('errEmail');

    var inputPassword = document.getElementById('password');
    var errPass = document.getElementById('errPass');

    var inputRepass = document.getElementById('Repassword');
    var errRepass = document.getElementById('errRepass');

    var btnLogin = document.querySelector('.btn-login');

    inputUser.onblur = function () {
        if (this.value.length > 50) {
            errUser.innerText = 'Nhập lại username';
            errUser.style.color = 'red';
            this.style.border = '1px solid red';
        } else {
            errUser.innerText = '';
            this.style.border = '1px solid #DEE2E6';
        }
    }

    inputEmail.onblur = function () {
        if (inputEmail.value.length > 50) {
            errEmail.innerText = 'Nhập lại email';
            errEmail.style.color = 'red';
            inputEmail.style.border = '1px solid red';
        } else {
            errEmail.innerText = '';
            inputEmail.style.border = '1px solid #DEE2E6';
        }
    }

    inputPassword.onblur = function () {
        if (inputPassword.value.length > 50) {
            errPass.innerText = 'Nhập lại password';
            errPass.style.color = 'red';
            inputPassword.style.border = '1px solid red';
        } else {
            errPass.innerText = '';
            inputPassword.style.border = '1px solid #DEE2E6';
        }
    }

    inputRepass.onblur = function () {
        if (inputRepass.value.length > 50 || inputRepass.value != inputPassword.value) {
            errRepass.innerText = 'Xác nhận lại password';
            errRepass.style.color = 'red';
            inputRepass.style.border = '1px solid red';
        } else {
            errRepass.innerText = '';
            inputRepass.style.border = '1px solid #DEE2E6';
        }
    }

    btnLogin.onclick = function (e) {
        e.preventDefault();
        let hasErr = false;

        if (inputUser.value.length == '') {
            errUser.innerText = 'Nhập username';
            errUser.style.color = 'red';
            inputUser.style.border = '1px solid red';
            hasErr = true;
        } else {
            errUser.innerText = '';
            inputUser.style.border = '1px solid #DEE2E6';
        }

        if (inputEmail.value === '') {
            errEmail.innerText = 'Nhập  email';
            errEmail.style.color = 'red';
            inputEmail.style.border = '1px solid red';
            hasErr = true;
        } else {
            errEmail.innerText = '';
            inputEmail.style.border = '1px solid #DEE2E6';
        }

        if (inputPassword.value == '') {
            errPass.innerText = 'Nhập  password';
            errPass.style.color = 'red';
            inputPassword.style.border = '1px solid red';
            hasErr = true;
        } else {
            errPass.innerText = '';
            inputPassword.style.border = '1px solid #DEE2E6';
        }

        if(hasErr == false){
            document.getElementById('login-form').submit();
        }

        // const user = {
        //     name: inputUser.value,
        //     email: inputEmail.value,
        //     password: inputPassword.value,
        //     rePassword: inputRepass.value,
        // };
        // let json = JSON.stringify(user);
        // // localStorage.setItem("login", email.value);
        //
        // for (let i = 0; i < localStorage.length; i++) {
        //     if (inputEmail.value === localStorage.key(i)) {
        //         return alert("Tài khoản đã tồn tại!");
        //     }
        // }
        //
        // if (hasErr == false) {
        //     alert("Đăng ký thành công!");
            // localStorage.setItem(inputEmail.value, json);
            // document.getElementById('login-form').submit();
        // }


    }
}