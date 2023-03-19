<%--
  Created by IntelliJ IDEA.
  contrat: abdra
  Date: 12/03/2023
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mes Conges</title>
</head>

<body>
<%@include file="/Users/Employe/sidebar.jsp"%>
<div class='dashboard-content'>
    <div class='container'>
        <div class='card'>
            <div class='card-header'>
                <h4>Mes Conges</h4>
            </div>
            <div class='card-body'>
                <div class="card mb-4">
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                            <tr>
                                <th>Intitule</th>
                                <th>Raison</th>
                                <th>Nombre de jour</th>
                                <th>Date de debut</th>
                                <th>Date de fin</th>
                                <th>Affectation de salaire</th>
                                <th>Etat</th>
                            </tr>
                            </thead>
                          
                            <tbody>
                            <c:forEach var="conge" items="${congees}">
                            <tr>
                                <td>${conge.intitule }</td>
                                <td>${conge.reason }</td>
                                <td>${conge.nbJour }</td>
                                <td>${conge.dateDebut }</td>
                                <td>${conge.dateFin }</td>
                                <c:if test="${conge.affectSalaire}"><td>Oui</td></c:if>
                                <c:if test="${!conge.affectSalaire }"><td>Non</td></c:if>
								<c:if test="${conge.etat}"><td>Actif</td></c:if>
                                <c:if test="${!conge.etat }"><td>En attente</td></c:if>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<script >
	window.addEventListener('DOMContentLoaded', event => {
	    const datatablesSimple = document.getElementById('datatablesSimple');
	    if (datatablesSimple) {
	        new simpleDatatables.DataTable(datatablesSimple);
	    }
	});
</script>
</body>
</html>
