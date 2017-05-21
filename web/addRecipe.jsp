
<%@include file="Header.jsp" %>

    <div>
    <form method="post" action="addController" id="form-submit" enctype="multipart/form-data">
        <script type="text/javascript" src="script.js"></script>
            <h3>Add recipe form</h3>
              <label for="Rname">Recipe Name</label> <br>
                        <input type="text" name="Rname" id="Rname">
                        <span class="error" style="color:red; display:none;">Recipe should not be empty</span>
             
              <br>
              <label for="ingredients">Ingredients</label> <br>
              <textarea type="textarea" cols="30" rows="5" name="ingredients" id="ingredients"></textarea>
              <span class="error" style="color:red; display:none;">Ingredients should not be empty</span>
               
              <br>
              <label for="description">Description</label> <br>
              <textarea type="textarea" cols="30" rows="5" name="description" id="description"></textarea>
                            <span class="error" style="color:red; display:none;">Description should not be empty</span>

                            
                            
              <br>
              <label for="time">Time (about how long will it take?)</label> <br>
                        <input type="text" name="time" id="time">
                        <span class="error" style="color:red; display:none;">Time should not be empty</span>
              <br>
              <label for="file">Add Photo</label>
                        <input id="file" name="file" class="input-file" type="file">
                        <span class="error" style="color:red; display:none;">Link should not be empty</span>
              <br>
              

              <label for="genderUser">Difficulty level &emsp;</label> <br>
                        <label for="easy">Easy </label>
                        <input type="radio" name="difficulty" id="easy" value="easy" checked>
                        <label for="difficult">&emsp; &emsp; Difficult</label>
                        <input type="radio" name="difficulty" id="difficult" value="difficult">
          <br>     
        <input type="submit" value="Submit" name="send" class="btn btn-primary btn-sm">
        <input type="reset" value="Reset" name="clear" class="btn btn-primary btn-sm">

    </form>

<%@include file="Footer.jsp" %>
