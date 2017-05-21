
<%@include file="Header.jsp" %>

    <div>
    
            <h3>Registration form</h3>
            <script type="text/javascript" src="script.js"></script>
            <form name="regform" method="post" action="registrationController" onsubmit="return validateForm();"> 
              <label for="name">Name</label>
                        <input type="text" name="name" id="name">
                        <span id="ename" style="color:red; display:none;">Name should not be empty or numeric</span>
              <br>
              <label for="username">Username</label>
                        <input type="text" name="username" id="username">
                            <span id="eusername" style="color:red; display:none;">Username is not valid</span>
                            <span  style="color:red;">${requestScope.usernameerror}</span>
                            
              <br>
              <label for="password">Password</label>
                        <input type="password" name="password" id="password">
                        <span id="epassword" style="color:red; display:none;">Password should not be empty</span>
              <br>
              <label for="r-password">Repeat Password</label>
                        <input type="password" name="repassword" id="repassword">
                        <span id="erepassword" style="color:red; display:none;">Your passwords should match</span>

              <br>
              <label for="email">Email</label>
                    <input type="email" name="email" id="email">
                    <span id="eemail" style="color:red; display:none;">Email format not OK!</span>
          <br>
              <label for="gender">Gender</label>
                          <label for="male">Male</label>

                      <input type="radio" name="gender" id="male" value="male" checked>
                          <label for="female">Female</label>

                      <input type="radio" name="gender" id="female" value="female">
                      

               <br>
                <label for="mailist">Subscribe for maillist</label>
                <input type="checkbox" name="maillist" id="maillist"> 
                        <br>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset" name="clear">

        <span id="main-error" style="font-weight:700; color:red; display:none">Check all the errors</span>

    </form>

<%@include file="Footer.jsp" %>