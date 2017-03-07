$(document).ready(function(){
	 var path="assets/images/products/electronics/table/";
  $("#producttable").DataTable({
	
	  "ajax": {
		    "url": "/onlinemarket-frontend/products/all",
		    "dataSrc": ""
		  },
	  "columns": [
          { "data": "productName" },
          { "data": "productPrice" },
          {"data":null,
        	  "render":function(data,type,row){
        		  return "<img src='"+path+row.url+"' width='25px' height='25px'></img>";
        	  }
          },
          
          {"data":"productId",
        	  "render":function(data,type,row){
        		  return "<a href='getproduct/"+row.productId+"' class='btn btn-info'>view</a>";
        	  }
          },
        	
          {"data":"status",
        	  "render":function(data,type,row){
        		  if(row.status=='false')
        		  return "<a href='#' class='btn btn-warning'>Out of Stoke</a>";
        		  else{
        			  return "<a href='#' class='btn btn-primary'>Available</a>";
        		  }
        	  }
          } ,
          {"data":"",
        	  "render":function(data,type,row){
        		  return "<a href='#' class='btn btn-primary'>Add Cart</a>";
        	  }
          }  
                    
      ]
  });
    
    
});