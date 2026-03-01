<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

 <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
            
<body style="background: url(img/133665265304409136.jpg);background-size: cover;background-attachment: fixed;">
   
   <div class ="container">
   
   <div class="row">
       <div class="col m6 offset-m3">
       
           <div class="card">
           <div class="card-content">
           
           <h3 style="margin-top: 10px" class="center-align">Register here !!</h3>
           <h5 id='msg' class ='center-align ' ></h5>
           
           
           
               <div class="form center-align">
              
               
           <form action="RegisterServlet" method="post" id="myform" enctype="multipart/form-data">
               <input type="text" name="user_name" placeholder="Enter user Name" />
               <input type="password" name="user_password" placeholder="Enter user Password" />
               <input type="email" name="user_email" placeholder="Enter user Email" />
               
                    <div class="file-field input-field">
      <div class="btn blue">
        <span>File</span>
        <input name="image"  type="file">
      </div>
      <div class="file-path-wrapper">
        <input class="file-path validate" type="text">
      </div>
    </div> 
                       
                        <button type="Submit" class="btn light-blue">Submit</button>
               
               
               
               
               </form>
               </div>
               
               <div class ="loader center-align" style="margin-top: 15px; display:none ">
               
               
    <div class="preloader-wrapper big active">
      <div class="spinner-layer spinner-blue">
        <div class="circle-clipper left">
          <div class="circle"></div>
        </div><div class="gap-patch">
          <div class="circle"></div>
        </div><div class="circle-clipper right">
          <div class="circle"></div>
        </div>
      </div>

      <div class="spinner-layer spinner-red">
        <div class="circle-clipper left">
          <div class="circle"></div>
        </div><div class="gap-patch">
          <div class="circle"></div>
        </div><div class="circle-clipper right">
          <div class="circle"></div>
        </div>
      </div>

      <div class="spinner-layer spinner-yellow">
        <div class="circle-clipper left">
          <div class="circle"></div>
        </div><div class="gap-patch">
          <div class="circle"></div>
        </div><div class="circle-clipper right">
          <div class="circle"></div>
        </div>
      </div>

      <div class="spinner-layer spinner-green">
        <div class="circle-clipper left">
          <div class="circle"></div>
        </div><div class="gap-patch">
          <div class="circle"></div>
        </div><div class="circle-clipper right">
          <div class="circle"></div>
        </div>
      </div>
    </div>
               
               
          <h5>Please Wait.... </h5>     
               
               </div>
           
           
           </div>
       
       
       </div>
   
   
    
         </div>
   
   
   </div>
  
   
   </div>
   
   <script
  src="https://code.jquery.com/jquery-4.0.0.min.js"
  integrity="sha256-OaVG6prZf4v69dPg6PhVattBXkcOWQB62pdZ3ORyrao="
  crossorigin="anonymous"></script>
  
  <script>
  $(document).ready(function () {
	  
	  console.log("page is ready....")
	  
	  $("#myform").on('submit',function(event){
		  event.preventDefault();
		  
		  //var f=$(this).serialize();
		  let f=new FormData(this);
		  
		  console.log(f);
		  
		  $(".loader").show();
		  $(".form").hide();
		  
		  
		  
		  
		  $.ajax({
			  url: "RegisterServlet",
		  data: f,
		  type: 'POST',
		  success: function(data,textStatus,jqHXR){
			  
			  console.log(data);
			  console.log("success");
			  
			  if(data.trim()=="done")
				  {
				  $('#msg').html("Succesfully Registered !!")
				$('#msg').addClass('green-text')
				  
				  }else{
				  $('#msg').html("Something Went Wrong!!")
				  $('#msg').addClass('red-text')
			  }     
			  $(".loader").hide();
			  $(".form").show();
			  
			  
		  },
		 error: function(jqHXR,textStatus,errorThrown){
			 console.log(data);
			 console.log("error.....");
			 
			 $(".loader").hide();
			  $(".form").show();
			  $('#msg').html("Something went wrong on server !!")
			  
			  
		 }  
		  
		  processData: false,
			  contentType: false;
			  
		  });
		  
	  });
	  
	  });
  
  
  </script>
   

</body>
</html>