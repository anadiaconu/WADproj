<%@include file="Header.jsp" %>

<form method="post" action="addController" id="form-submit" data-toggle="validator" enctype="multipart/form-data">
    <h2 class="form-headline">Add a recipe:</h2>
    
    <div class="form-group has-feedback">
        <div class="input-group">
            <span class="input-group-addon" id="Rname-label">Title</span>
            <input type="text" class="form-control" maxlength="255" aria-describedby="Rname-label" name="Rname" id="Rname" required>
        </div>
        <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
        <div class="help-block with-errors">${requestScope.usernameerror}</div>
    </div>
    
    <div class="form-group has-feedback">
        <div class="input-group">
            <span class="input-group-addon" id="time-label">Time Required</span>
            <input type="text" class="form-control" maxlength="255" aria-describedby="time-label" name="time" id="time" required>
        </div>
        <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
        <div class="help-block with-errors"></div>
    </div>

    <div class="form-group has-feedback">
        <div class="input-group">
            <span class="input-group-addon" id="ingredients-label">Ingredients</span>
            <textarea class="form-control" aria-describedby="ingredients-label" name="ingredients" id="ingredients" required></textarea>
        </div>
        <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
        <div class="help-block with-errors"></div>
    </div>
    
    <div class="form-group has-feedback">
        <div class="input-group">
            <span class="input-group-addon" id="description-label">Description</span>
            <textarea class="form-control" aria-describedby="description-label" name="description" id="description" required></textarea>
        </div>
        <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
        <div class="help-block with-errors"></div>
    </div>
    
    <div class="input-group">
        <label for="difficulty">Difficulty level:</label>
        <div class="radio-space"><input type="radio" name="difficulty" id="easy" value="easy" checked><label for="easy">Easy</label></div>
        <div class="radio-space"><input type="radio" name="difficulty" id="difficult" value="difficult"><label for="difficult">Difficult</label></div>
    </div>

    <div class="form-group">
        <label for="file">Add photo</label>
        <input id="file" name="file" class="input-file" type="file">
    </div>
    
    <div class="row text-center">
        <button type="submit" class="btn btn-success" name="send">Submit</button>
        <button type="reset" class="btn btn-warning" name="clear">Reset</button>
    </div>
</form>

<%@include file="Footer.jsp" %>
