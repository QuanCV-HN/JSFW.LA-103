window.onload = function(){

    var inputFirstname = document.getElementById('firstName');
    var errFirtname = document.getElementById('errFirtname');

    var inputLasttname = document.getElementById('lastName');
    var errLastname = document.getElementById('errLastname');

    var inputEmail = document.getElementById('email');
    var errEmail = document.getElementById('errorEmail');

    var btnSubmit = document.querySelector('#btnSubmit');

    inputFirstname.onblur = function(){
        if(inputFirstname.value.length > 50){
            errFirtname.innerText = 'Nhập lại Firt name';
            errFirtname.style.color = 'red';
            inputFirstname.style.border = '1px solid red';
        }else{
            errFirtname.innerText = '';
            inputFirstname.style.border = '1px solid #DEE2E6';
        }
    } 

    inputLasttname.onblur = function(){
        if(inputLasttname.value.length > 50){
            errLastname.innerText = 'Nhập lại Last name';
            errLastname.style.color = 'red';
            inputLasttname.style.border = '1px solid red';
        }else{
            errLastname.innerText = '';
            inputLasttname.style.border = '1px solid #DEE2E6';
        }
    } 

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

    btnSubmit.onclick  = function(e){
        e.preventDefault();
        let hasErr = false;

        if(inputFirstname.value == ''){
            errFirtname.innerText = 'Nhập  email';
            errFirtname.style.color = 'red';
            inputFirstname.style.border = '1px solid red';
            hasErr = true;
        }else{
            errFirtname.innerText = '';
            inputFirstname.style.border = '1px solid #DEE2E6';
        }

        if(inputLasttname.value == ''){
            errLastname.innerText = 'Nhập email';
            errLastname.style.color = 'red';
            inputLasttname.style.border = '1px solid red';
            hasErr = true;
        }else{
            errLastname.innerText = '';
            inputLasttname.style.border = '1px solid #DEE2E6';
        }


        if(inputEmail.value == ''){
            errEmail.innerText = 'Nhập email';
            errEmail.style.color = 'red';
            inputEmail.style.border = '1px solid red';
            hasErr = true;
        }else{
            errEmail.innerText = '';
            inputEmail.style.border = '1px solid #DEE2E6';
        }

        if(hasErr == false){
            document.querySelector('.form-body').submit();
        }

    }

   

}