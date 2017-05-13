
<%@include file="Header.jsp" %>

    <div>
    <form method="post" action="registrationController" id="form-submit">
            <h3>Add recipe form</h3>
              <label for="Rname">Recipe Name</label>
                        <input type="text" name="Rname" id="Rname">
                        <span class="error" style="color:red; display:none;">Recipe should not pe empty</span>
              <br>
              <label for="description">Description</label>
                        <input type="textarea" rows="7" cols="50"  name="description" id="description">
                            <span class="error" style="color:red; display:none;">Description should not pe empty</span>

                            
                            
              <br>
              <label for="time">Time (about how long will it take?)</label>
              <br>
                        <input type="text" name="time" id="time">
                        <span class="error" style="color:red; display:none;">Time should not pe empty</span>
              <br>
              <label for="link">Image URL (how will it look like?)</label>
              <br>
                        <input type="text" name="link" id="link">
                        <span class="error" style="color:red; display:none;">Link should not pe empty</span>
              <br>
              

              <label for="genderUser">Difficulty level</label>
              <br>      <label for="easy">Easy</label>
              
                         <input type="radio" name="difficulty" id="easy" value="easy">
              <br>            <label for="difficult">Difficult</label>

                      <input type="radio" name="difficulty" id="difficult" value="difficult">
                      <span class="error" style="color:red; display:none;">Difficulty level should be selected</span>

          <br>     
        <input type="submit" value="Submit" name="send" class="btn btn-primary btn-sm">
        <input type="reset" value="Reset" name="clear" class="btn btn-primary btn-sm">

         
        
        <span id="main-error" style="font-weight:700; color:red; display:none">Check all the errors</span>

    </form>

<%@include file="Footer.jsp" %>
