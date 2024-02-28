//
//
// window.onload = function (){
//
//     var pageSize = 3;
//     var pageNumber = 2;
//     loadData(pageNumber,pageSize);
//
//
// }
//
// function loadData(pageNumber,pageSize){
//     $.ajax({
//         url :  'http://localhost:8080/viewcontent-rest?pageNumber='+`${pageNumber}`+ '&pageSize='+`${pageSize}`,
//         method : 'GET',
//         contentType: 'application/json',
//         success : function (response){
//             console.log(response)
//
//             var tableContent = '';
//             for (let i = 0; i < response.length; i++) {
//                 let ct = response[i];
//                 let row =`  <tr class="row-body">
//                                     <td class="col1">${i+1}</td>
//                                     <td class="col2">${ct.title}</td>
//                                     <td class="col3">${ct.brief}</td>
//                                     <td class="col4">${ct.createDate}</td>
//                                 </tr>`;
//
//                 tableContent += row;
//             }
//             $('tbody').html(tableContent);
//         }})
// }
//
