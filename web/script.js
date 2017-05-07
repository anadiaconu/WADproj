$( document ).ready(function() {
				$( "#name" ).blur(function() {
					if($(this).val().length < 1){
						$("#name+span").show();
					} 
					else{
						$("#name+span").hide();
					}
				});     
				$( "#username" ).blur(function() {
					if($(this).val().length < 1){
						$("#username+span").show();
					}
					else{
						$("#username+span").hide();
					}
				});     
				$( "#password" ).blur(function() {
					if($(this).val().length < 1){
						$("#password+span").show();
					}
					else{
						$("#password+span").hide();
					}
				});     
				$( "#phone" ).blur(function() {
					if($(this).val().length < 1){
						$("#phone+span").show();
					}
					else{
						$("#phone+span").hide();
					}
				});     
				$( "#email" ).blur(function() {
					if($(this).val().length < 1){
						$("#email+span").show();
					}
					else{
						$("#email+span").hide();
					}
				});     
				$( "#r-password" ).blur(function() {
					if($(this).val() != $( "#password" ).val()){
						$("#r-password+span").show();
					}
					else{
						$("#r-password+span").hide();
					}
				});     

				$( "#form-submit" ).submit(function(e) {

					if ($(".error").is(":visible")){
						$("#main-error").show();
                                                e.preventDefault();
					} else{
						$("#main-error").hide();					
					}
					if(!$( "input[value='gender']" ).is(":checked")){
						$("#female+span").show();
                                                e.preventDefault();
					}
					else{
						$("#female+span").hide();
					}
					
					
				});     
			});
