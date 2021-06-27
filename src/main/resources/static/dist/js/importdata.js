/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
 
$("#fileUploadForm").on('submit',function (e) {
    e.preventDefault();
$.ajax({
  url: '/import-data-process',
  type: 'POST',
  data: new FormData($('#fileUploadForm')[0]),
  enctype: 'multipart/form-data',
  processData: false, // tell jQuery not to process the data
  contentType: false, // tell jQuery not to set contentType
  cache: false,

  success: function(res) {
    console.log(res);
  },

  error: function(res) {
    console.log('ERR: ' + res);
  }
});
    });
    
});
