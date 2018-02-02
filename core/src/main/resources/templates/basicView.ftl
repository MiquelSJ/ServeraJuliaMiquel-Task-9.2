<!doctype html>
<html lang="en">
<head>
    <title>Restaurants</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.min.css" >

    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">

    <!-- Favicon -->
    <link rel="shortcut icon" type="image/png" href="http://elowcarbfoodlist.org/wp-content/uploads/2013/01/bacon-256.jpg"/>
</head>
<body>
<!-- Navigation bar -->
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">Restaurants</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

</nav>
<main role="main" class="container">
    <div class="row featurette">
        <div class="col-md-7">
            <h1>${title!""}</h1>
            <h2 class="featurette-heading">
                <br/><span class="text-muted">Llista dels restaurants.</span>
            </h2>
        </div>
    </div>
<#if posts??>
    <div class="row center mt-2">
        <#list posts as item>
            <div class="col-md-3">
                <div class="media mt-5 ml-5">
                    <img class="align-self-start mr-3 rounded-circle"
                         src="${item.images!""}"
                         alt="Random Image" width="80" height="80">
                    <div class="media-body">
                        <h5 class="mt-0">${item.name!""}</h5>
                        <p>${item.address!""}</p>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</#if>
</main>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"
        integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4"
        crossorigin="anonymous"></script>
</body>
</html>