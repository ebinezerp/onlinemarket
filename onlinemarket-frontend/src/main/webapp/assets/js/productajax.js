$(document).ready(function(){
	 var path="assets/images/products/electronics/";
  $("#producttable").DataTable({
	
	  "ajax": {
		    "url": "/onlinemarket-frontend/products/all",
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

          {"data":"productName",
        	  "render":function(data,type,row){
        		  return "<div class='zoomin'><img src='"+path+data+".jpg'></img></div>";
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
        		  return "<a href='customer/add/"+row.productId+"/addcart' class='btn btn-primary'>Add Cart</a>";
        	  }
          }  
                    
      ]
  });
    
    
});