/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Car;
import Data.CarDB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author steph
 */
public class cars extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
       String submit=request.getParameter("submit");
         String id=request.getParameter("id");
     String make=request.getParameter("make");
     String model=request.getParameter("model");
     String debut=request.getParameter("debut");
     String carEngine=request.getParameter("carengine");
     String price=request.getParameter("price");
     String color=request.getParameter("color");
     String regiistration=request.getParameter("regiistration");
     String fuel=request.getParameter("fuel");
     Car car=new Car();
 

     
     
  double Price;
   try{  Price=Double.parseDouble(price);}catch(Exception e){
  Price=0;}
   int Year;
     try{  Year=Integer.parseInt(debut);}catch(Exception e){
  Year=0;}
  


    
     
    
       if (submit.equals("addcar")){
          
            try {
                car.setCarEngine(carEngine);
car.setColor(color);
car.setDebut(Year);
car.setFuel(fuel);
car.setModel(model);
car.setMake(make);
car.setRegiistration(regiistration);
                CarDB.addCar(car);
                 request.setAttribute("msg","the car has been added to the table");
request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (Exception ex) {
              request.setAttribute("msg","you left some key feilds empty");
request.getRequestDispatcher("index.jsp").forward(request, response);  
            }
       }
       
       
       
    else if (submit.equals("searchcar")){
            try {
                if(make==null)make="";
                 if(color==null)color="";
                  if(fuel==null)fuel="";
                  
                  car.setMake(make);
                  car.setDebut(Year);
                  car.setColor(color);
                  car.setFuel(fuel);
             request.setAttribute("cars",CarDB.searchCar(car));
request.getRequestDispatcher("index.jsp").forward(request, response);
             
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
            } 
       
       }

       
       
       else if (submit.equals("deletecar")){
            try {  if(id==null||id.equals("")||id.trim().length()==0){request.setAttribute("msg","you left some key feilds empty");
request.getRequestDispatcher("index.jsp").forward(request, response);  }
    int Id=0;
  try{  Id=Integer.parseInt(id);}catch(Exception e){
  Id=0;}
                
                  car.setId(Id);
                CarDB.deleteCar(car.getId());
                 request.setAttribute("msg","the table has been updated. the car has been deleted");
request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (Exception ex) {
              request.setAttribute("msg","you left some key feilds empty");
request.getRequestDispatcher("index.jsp").forward(request, response);  
            }
       }
       
       
        else if (submit.equals("updatecar")){
            try {
                car.setCarEngine(carEngine);
car.setColor(color);
car.setDebut(Year);
car.setFuel(fuel);
car.setModel(model);
car.setMake(make);
car.setRegiistration(regiistration);
                  if(id==null||id.equals("")||id.trim().length()==0){request.setAttribute("msg","you left some key feilds empty");
request.getRequestDispatcher("index.jsp").forward(request, response);  }
    int Id=0;
  try{  Id=Integer.parseInt(id);}catch(Exception e){
  Id=0;}
                CarDB.updateCar(car);
                 request.setAttribute("msg","the table has been updated");
request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
            }catch (Exception ex) {
                
              request.setAttribute("msg","you left some key feilds empty");
request.getRequestDispatcher("index.jsp").forward(request, response);  
            }
       
       }
        
         else if (submit.equals("retreivecar")){
            try {
                  if(id==null||id.equals("")||id.trim().length()==0){request.setAttribute("msg","you left some key feilds empty");
request.getRequestDispatcher("index.jsp").forward(request, response);  }
    int Id=0;
  try{  Id=Integer.parseInt(id);}catch(Exception e){
  Id=0;}
  car.setId(Id);
             request.setAttribute("ca",CarDB.retreiveCar(car.getId()));
request.getRequestDispatcher("index.jsp").forward(request, response);

             
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
                 request.setAttribute("msg","error this function doesn't work");
request.getRequestDispatcher("index.jsp").forward(request, response);
            }
       
       }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
