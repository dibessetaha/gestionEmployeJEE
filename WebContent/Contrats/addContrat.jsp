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
                <h4>Contrat</h4>
            </div>
            <div class='card-body'>
                <div class="card mb-4">
                    <div class="form-body">
                        <div class="row">
                            <div class="form-content">
                                <div style="background-color: #152733;" class="form-items">
                                    <h3>Ajouter un Contrat</h3>
                                    <p>informations de Contrat</p>
                                    <form method="post" action="">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <input class="form-control" type="text" name="title" placeholder="Titre de contrat" >
                                            </div>
                                            <div class="col-md-6">
    										 <select name="type" class="form-select mt-3" required>
                                                    <option  selected disabled value="">Type de contrat</option>
                                                    <option value="CDI">CDI</option>
                                                    <option value="CDD">CDD</option>
                                                    <option value="CDI">CTT</option>
                                                </select>                                       
                                           </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                       		    <input class="form-control mt-3" type="text" name="dateDebut"  onfocus="(this.type='date')" onblur="(this.type='text')" placeholder="Date de debut" required>   		
                                            </div>
                                            <div class="col-md-6">
                                                <select name="poste" class="form-select mt-3" >
	                                                <option selected disabled value="">Poste Occupe</option>
	                                                <option value="jweb">Junior Web Developer</option>
	                                                <option value="sweb">Senior Web Developer</option>
	                                                <option value="pmanager">Project Manager</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <input class="form-control mt-3" type="text" name="dateFin" onfocus="(this.type='date')" onblur="(this.type='text')" placeholder="Date de fin" required>
                                            </div>
                                            <div class="col-md-6">
                                            	<input class="form-control mt-3" type="number" name="salary" placeholder="Salaire" >
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <select name="etat" class="form-select mt-3" required>
                                                    <option selected disabled value="">Etat</option>
                                                    <option value="1">Actif</option>
                                                    <option value="0">Non actif</option>
                                                </select>
                                            </div>
                                        </div>


                                        <div class="form-button mt-3">
                                            <button id="submit" type="submit" class="btn btn-primary">Ajouter contrat</button>
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
