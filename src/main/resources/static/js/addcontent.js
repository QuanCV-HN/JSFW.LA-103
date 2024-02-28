window.onload = function(){

    var inputTitle = document.getElementById('title');
    var errtitle = document.getElementById('errtitle');

    var btnSubmit = document.querySelector('#btnSubmit');

    inputTitle.onblur = function(){
        if(inputTitle.value.length > 50){
            errtitle.innerText = 'Nhập lại Title';
            errtitle.style.color = 'red';
            inputTitle.style.border = '1px solid red';
        }else{
            errtitle.innerText = '';
            inputTitle.style.border = '1px solid #DEE2E6';
        }
    } 


    btnSubmit.onclick  = function(e){
        e.preventDefault();
        let hasErr = false;

        if(inputTitle.value === ''){
            errtitle.innerText = 'Nhập  title';
            errtitle.style.color = 'red';
            inputTitle.style.border = '1px solid red';
            hasErr = true;
        }else{
            errtitle.innerText = '';
            inputTitle.style.border = '1px solid #DEE2E6';
        }


        if(hasErr == false){
            document.querySelector('.form-body').submit();
        }

    }

   

}