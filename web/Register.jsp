
<%@include file="Header.jsp" %>

    <div>
    <form method="post" action="registrationController" id="form-submit">
            <h3>Registration form</h3>
              <label for="name">Name</label>
                        <input type="text" name="name" id="name">
                        <span class="error" style="color:red; display:none;">Name should not pe empty</span>
              <br>
              <label for="username">Username</label>
                        <input type="text" name="username" id="username">
                            <span class="error" style="color:red; display:none;">Username should not pe empty</span>

              <br>
              <label for="password">Password</label>
                        <input type="password" name="password" id="password">
                        <span class="error" style="color:red; display:none;">Password should not pe empty</span>
              <br>
              <label for="r-password">Repeat Password</label>
                        <input type="password" name="r-password" id="r-password">
                        <span class="error" style="color:red; display:none;">Your passwords should match</span>

              <br>
              <label for="email">Email</label>
                    <input type="email" name="email" id="email">
                    <span class="error" style="color:red; display:none;">Email should not be empty</span>
          <br>
              <label for="genderUser">Gender</label>
                          <label for="male">Male</label>

                      <input type="radio" name="sex" id="male" value="male">
                          <label for="female">Female</label>

                      <input type="radio" name="sex" id="female" value="female">
                      <span class="error" style="color:red; display:none;">Gender should be selected</span>

               <br>
              <label for="country">Country</label>
              <select name="country" id="country">
                          <option value="1"> Romania</option>
                          <option value="2">etc</option>
                          <option value="3">etc</option>
                          <option value="4">etc</option>
              </select>
                       <br>
                <label for="mailist">Subscribe for maillist</label>
                <input type="checkbox" name="maillist" id="maillist"> 
                        <br>
        <input type="submit" value="Submit" name="send">
        <input type="reset" value="Reset" name="clear">

        <span id="main-error" style="font-weight:700; color:red; display:none">Check all the weeors</span>

    </form>

<%@include file="Footer.jsp" %>
