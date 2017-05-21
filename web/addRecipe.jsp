<%@include file="Header.jsp" %>

    <div>
        <form method="post" action="addController" id="form-submit">
            <script type="text/javascript" src="script.js"></script>
            <h3>Add recipe form</h3>
            <label for="Rname">Recipe Name</label>
            <input type="text" name="Rname" id="Rname" required>
            <span class="error" style="color:red; display:none;">Recipe should not be empty</span>
            <br>
            <label for="description">Description</label>
            <input type="textarea" name="description" id="description" required>
            <span class="error" style="color:red; display:none;">Description should not be empty</span>



            <br>
            <label for="time">Time (about how long will it take?)</label>
            <input type="text" name="time" id="time" required>
            <span class="error" style="color:red; display:none;">Time should not be empty</span>
            <br>
            <label for="link">Image(add path)</label>
            <input type="text" name="link" id="link" required>
            <span class="error" style="color:red; display:none;">Link should not be empty</span>
            <br>


            <label for="genderUser">Difficulty level &emsp;</label>
            <label for="easy">Easy </label>
            <input type="radio" name="difficulty" id="easy" value="easy" checked>
            <label for="difficult">&emsp; &emsp; Difficult</label>
            <input type="radio" name="difficulty" id="difficult" value="difficult">
            <br>
            <input type="submit" value="Submit" name="send" class="btn btn-primary btn-sm">
            <input type="reset" value="Reset" name="clear" class="btn btn-primary btn-sm">

        </form>

        <script type="text/javascript">
            (function($) {
                $('#form-submit').validate();
            }(jQuery));
        </script>

        <%@include file="Footer.jsp" %>
