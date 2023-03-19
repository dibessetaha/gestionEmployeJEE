<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link rel="stylesheet" href="/webproject/css/add.css">
    <title>Title</title>
</head>
<body>
<%@include file="/Users/Admin/sidebar.jsp"%>
<div class='dashboard-content'>
    <div class='container'>
        <div class='card'>
            <div class='card-header'>
                <h4>Poste  ${poste.intitule }</h4>
            </div>
            <div class='card-body'>
                <div class="card mb-4">
                    <div class="form-body">
                        <div class="row">
                            <div class="form-content">
                                <div style="background-color: #152733;" class="form-items">
                                    <h3>Modifier le Poste ${poste.intitule }</h3>
                                    <p>informations de Poste</p>
                                    <form method="post" action="">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <input class="form-control" type="text" name="intitule" value="${poste.intitule }" placeholder="Intitule de Poste" >
                                            </div>
                                            <div class="col-md-6">
    											<input class="form-control" type="number" name="placeVide" value="${poste.placeVide }" placeholder="Nombre de place Vide" >            
    											<input class="form-control" type="hidden" name="id" value="${poste.id }" placeholder="Nombre de place Vide" >            
                                           </div>
                                        </div>
                                        <div class="form-button mt-3">
                                            <button id="submit" type="submit" class="btn btn-primary">Modifier</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

</body>
</html>
