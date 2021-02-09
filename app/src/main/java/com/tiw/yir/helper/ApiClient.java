package com.tiw.yir.helper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "https://yir.yirkart.com/";



    public interface ENDPOINT {

        // User Modules
        String LOGIN = "login";
        String REGISTER = "register";
        String CHANGE_PASSWORD = "changePassword";
        String FORGOT_PASSWORD = "forgotPassword";
        String RECOVER_FORGOT_PASSWORD = "recoverForgotPassword";

        // Group Modules
        String ADD_GROUP = "addGroup";
        String GET_LIST_OF_GROUP = "getListOfGroups";
        String JOIN_GROUP = "joinGroup";

        // Membership modules
        String ADD_MEMBERSHIP = "addMembership";
        String GET_MEMBERSHIP_LIST = "getMembershipList";

        // Scholarships Modules
        // String ADD_SCHOLARSHIP = "addScholarship";
        String APPLY_FOR_SCHOLARSHIP = "applyForScholarship";
        String GET_LIST_OF_SCHOLARSHIP = "getListofScholarships";
        String GET_SCHOLARSHIP_AWARDS = "getScholarshipAwards";


        // Payment Modules
        String INITIATE_PAYMENT = "initiatePayment";


        //Elections Modules
        String APPLY_FOR_VOTE = "applyForVote";
        String CANDIDATE_LIST = "candidatesList";
        String GIVE_VOTE = "giveVote";
        String CALCULATE_RESULT = "calculateResult";








    }
}
