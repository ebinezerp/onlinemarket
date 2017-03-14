$(document).ready(function(){
	
  $("#categorytable").DataTable({
	
	  "ajax": {
		    "url": "/onlinemarket-frontend/admin/categories/all",
		    "dataSrc": ""
		  },
	  "columns": [
		
		  { "data": "categoryName" },
          {"data":null,
        	  "render":function(data,type,row){
        		  return "<a href='/onlinemarket-frontend/admin/"+row.id+"/editcategory' class='btn btn-primary'>Edit</a>";
        	  }
          },
          
          {"data":null,
        	  "render":function(data,type,row){
        		  return "<a href='/onlinemarket-frontend/admin/"+row.id+"/deletecategory' class='btn btn-primary'>Delete</a>";
        	  }
          }
                
      ]
  });
    
    
});