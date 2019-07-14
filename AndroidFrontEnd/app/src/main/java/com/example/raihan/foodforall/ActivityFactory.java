package com.example.raihan.foodforall;

import com.example.raihan.foodforall.AbstractClasses.IActivity;

public class ActivityFactory {
    IActivity IActivity = null;
    public IActivity createRequestPage(String s)
    {
         if(s.equals("Login"))
         {
             IActivity = new Login();
         }

         else if(s.equals("Register"))
         {
             IActivity = new Registration();
         }

         else if(s.equals("Home Page"))
         {
             IActivity = new HomePage();
         }

         else if(s.equals("Post Description"))
         {
             IActivity = new PostDescription();
         }

        else if(s.equals("My Request"))
        {
            IActivity = new MyRequests();
        }

        else if(s.equals("My Response")){
            IActivity = new MyResponses();
        }

        else if(s.equals("Food Request Data Entry"))
        {
            IActivity = new FoodRequestDataEntry();
        }
         else if(s.equals("Location"))
         {
             IActivity = new FoodRequestDataEntry_Location();
         }
         else if(s.equals("Amount"))
         {
             IActivity = new FoodRequestDataEntry_Amout();
         }
         else if(s.equals("Description"))
         {
             IActivity = new FoodRequestDataEntry_Description();
         }
         else if(s.equals("Volunteer"))
         {
             IActivity = new FoodRequestDataEntry_Volunteer();
         }
         else if(s.equals("Expiary Time"))
         {
             IActivity = new FoodRequestDataEntry_ExpiaryTime();
         }



        return IActivity;
    }
}
