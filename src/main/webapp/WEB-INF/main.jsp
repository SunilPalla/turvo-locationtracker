<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Location Tracker</h2>

<table border="1">
    <c:forEach var="location" items="${locations}">
        <tr>
            <td>${location.latitude}</td>
            <td>${location.longitude}</td>
            <td>${location.trackerType}</td>
            <td>${location.location}</td>
            <td>${location.vehicleSpeed}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
