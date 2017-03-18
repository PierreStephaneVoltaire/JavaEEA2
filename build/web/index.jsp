<%-- 
    Document   : index
    Created on : Mar 16, 2017, 8:40:11 PM
    Author     : steph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cars</title>
    </head>
    <body>
        <div class="container">
            <h2> cars</h2>
            <div class="row">
                <div class="col-md-6">
                    <form action="cars" method="post">
                        <div class="form-group">
                            <label for="id">Id:</label>
                            <input type="number" class="form-control" id="id" name="id" placeholder="Enter the ID of the car you'd like to delete" value=${ca.getId()}  >    
                        </div>
                        <div class="form-group">
                            <label for="make">make:</label>
                            <input type="text" class="form-control" id="make" name="make" placeholder="Enter the make of the car" value=${ca.getMake()} required="required">    
                        </div>
                        <div class="form-group">
                            <label for="price">price:</label>
                            <input type="number" step="any" class="form-control" id="price" name="price" placeholder="Enter the price of the car" value=${ca.getPrice()} required="required">    
                        </div>
                        <div class="form-group">
                            <label for="model">model:</label>
                            <input type="text" class="form-control" id="model" name="model" placeholder="Enter the model of the car"value=${ca.getModel()} required="required">    
                        </div>  
                        <div class="form-group">
                            <label for="debut">year:</label>
                            <input type="number" min="2000" max="2017" class="form-control" id="debut" name="debut" placeholder="Enter the year of release of the car" value=${ca.getDebut()} required="required">    
                        </div>  
                        <div class="form-group">
                            <label for="carengine">engine:</label>
                            <input type="text" class="form-control" id="carengine" name="carengine" placeholder="Enter the engine of the car"value=${ca.getCarEngine()} required="required">    
                        </div> 
                        <div class="form-group">
                            <label for="color">color:</label>
                            <input type="text" class="form-control" id="color" name="color" placeholder="Enter the color of the car"value=${ca.getColor()} required="required">    
                        </div> 
                        <div class="form-group">
                            <label for="registration">registration:</label>
                            <input type="text" class="form-control" id="registration" name="regiistration" placeholder="Enter the registration of the car" value=${ca.getRegiistration()} required="required">    
                        </div> 
                        <div class="form-group">
                            <label for="fuel">fuel:</label>
                            <input type="text" maxlength="1" class="form-control" id="fuel" name="fuel" placeholder="Enter the fuel type of the car" value=${ca.getFuel()} required="required">    
                        </div> 


                        <button type="submit" class="btn btn-default" value="addcar" name="submit">add car</button>

                        <button type="submit" class="btn btn-default" value="updatecar" name="submit">update car</button>

                    </form>

                    <h3>${msg}</h3>
                </div>

                <div class="col-md-6">

                    <form action="cars" method="post">

                        <div class="form-group">
                            <label for="make">make:</label>
                            <input type="text" class="form-control" id="make" name="make" placeholder="Enter the make of the car" >    
                        </div>


                        <div class="form-group">
                            <label for="debut">year:</label>
                            <input type="number" min="2000" max="2017" class="form-control" id="debut" name="debut" placeholder="Enter the year of release of the car">    
                        </div>  

                        <div class="form-group">
                            <label for="color">color:</label>
                            <input type="text" class="form-control" id="color" name="color" placeholder="Enter the color of the car" >    
                        </div> 

                        <div class="form-group">
                            <label for="fuel">fuel:</label>
                            <input type="text" maxlength="1" class="form-control" id="fuel" name="fuel" placeholder="Enter the fuel type of the car">    
                        </div>                       
                        <button type="submit" class="btn btn-default" value="searchcar" name="submit">Search car</button>
                    </form>
                    <br>
                    <table class="table table-striped">
                        <c:forEach var="car" items="${cars}">
                            <tr>
                                <td>
                                    ${car.getMake()}
                                </td>
                                <td>
                                    ${car.getModel()}
                                </td>
                                <td>
                                    ${car.getDebut()}
                                </td>
                                <td>
                                    ${car.getPrice()}
                                </td>
                                <td>
                                    ${car.getColor()}
                                </td>
                                <td>
                                    ${car.getCarEngine()}
                                </td>
                                <td>
                                    ${car.getRegiistration()}
                                </td>

                            </tr> 

                        </c:forEach>  

                    </table>


                </div>

            </div>          

            <div class="row">
                <div class="col-md-6">
                    <form action="cars" method="post">

                        <div class="form-group">
                            <label for="id">Id:</label>
                            <input type="number" class="form-control" id="id" name="id" placeholder="Enter the ID of the car you'd like to update" >   

                        </div>
                        <button type="submit" class="btn btn-default" value="retreivecar" name="submit">retrieve car</button>
                    </form>
                </div>
                <div class="col-md-6">

                    <form action="cars" method="post">

                        <div class="form-group">
                            <label for="id">Id:</label>
                            <input type="number" class="form-control" id="id" name="id" placeholder="Enter the ID of the car you'd like to delete" >   

                        </div>
                        <button type="submit" class="btn btn-default" value="deletecar" name="submit">delete car</button>
                    </form>
                </div>

            </div>     
        </div>


        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"/>
    </body>
</html>
