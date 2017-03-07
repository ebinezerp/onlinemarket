$(document).ready(function(){
	 var path="assets/images/products/electronics/table/";
  $("#productstable").DataTable({
	
	  "ajax": {
		    "url": "/onlinemarket-frontend/adminproducts/all",
		    "dataSrc": ""
		  },
	  "columns": [
          { "data": "productName" },
          { "data": "",
        	"render":function(data,type,row)
        	{
        	  return "&#8360;."+row.productPrice+"";
          }  
          
          },
          
          {"data":null,
        	  "render":function(data,type,row){
        		  return "<img src='"+path+row.url+"' width='25px' height='25px'></img>";
        	  }
          },
          
          {"data":"productId",
        	  "render":function(data,type,row){
        		  return "<a href='/onlinemarket-frontend/admin/"+row.productId+"/editproduct' class='btn btn-primary'>Edit</a>";
        	  }
          },
        	
         {"data":"",
        	  "render":function(data,type,row){
        		  return "<a href='/onlinemarket-frontend/admin/"+row.productId+"/deleteproduct' class='btn btn-primary'>Delete</a>";
        	  }
          }  
                    
      ]
  });
    
    
});