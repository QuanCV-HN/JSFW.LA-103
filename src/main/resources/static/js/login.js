window.onload = function(){
    var inputEmail = document.getElementById('email');
    var errEmail = document.getElementById('errorEmail');

    var inputPassword = document.getElementById('password');
    var errPass = document.getElementById('errorPass');

    var btnLogin = document.querySelector('.btn-login');

    inputEmail.onblur = function(){
        if(inputEmail.value.length > 50){
            errEmail.innerText = 'Nhập lại email';
            errEmail.style.color = 'red';
            inputEmail.style.border = '1px solid red';
        }else{
            errEmail.innerText = '';
            inputEmail.style.border = '1px solid #DEE2E6';
        }
    }

    inputPassword.onblur =function(){
        if(inputPassword.value.length > 50){
            errPass.innerText = 'Nhập lại password';
            errPass.style.color = 'red';
            inputPassword.style.border = '1px solid red';
        }else{
            errPass.innerText = '';
            inputPassword.style.border = '1px solid #DEE2E6';
        }
    }

    btnLogin.onclick  = function(e){
        e.preventDefault();
        let hasErr = false;

        if(inputEmail.value === ''){
            errEmail.innerText = 'Nhập lại email';
            errEmail.style.color = 'red';
            inputEmail.style.border = '1px solid red';
            hasErr = true;
        }else{
            errEmail.innerText = '';
            inputEmail.style.border = '1px solid #DEE2E6';
        }

         if(inputPassword.value == ''){
            errPass.innerText = 'Nhập lại password';
            errPass.style.color = 'red';
            inputPassword.style.border = '1px solid red';
            hasErr = true;
        }else{
            errPass.innerText = '';
            this.style.border = '1px solid #DEE2E6';
        }

        if(hasErr == false){
            document.getElementById('login-form').submit();
        }

        //lấy dữ liệu của key thành object, email.value = key
        // let user = JSON.parse(localStorage.getItem(email.value));

    }

   

}