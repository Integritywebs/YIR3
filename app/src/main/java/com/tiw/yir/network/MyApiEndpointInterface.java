package com.tiw.yir.network;

import com.tiw.yir.helper.ApiClient;
import com.tiw.yir.model.AddScholarship;
import com.tiw.yir.model.ApplyForScholarshipResponse;
import com.tiw.yir.model.CandidateListResponse;
import com.tiw.yir.model.ElectionDataResponse;
import com.tiw.yir.model.GiveVoteResponse;
import com.tiw.yir.model.RegistrationResponse;
import com.tiw.yir.model.ScholarshipAwardResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface MyApiEndpointInterface {

    /* Elections*/
    @FormUrlEncoded
    @POST(AppConstant.ENDPOINT.APPLY_FOR_VOTE)
    Call<ElectionDataResponse> apply_for_vote(@Header("authorization") String token, @Field("full_name") String user_Name,
                                              @Field("email") String user_email,
                                              @Field("mobile") String user_mobile,
                                              @Field("dob") String user_dob,
                                              @Field("election_group") String election_group,
                                              @Field("about_yourself") String about_yourself,
                                              @Field("election_menifesto") String election_menifesto);


    @FormUrlEncoded
    @POST(AppConstant.ENDPOINT.GIVE_VOTE)
    Call<GiveVoteResponse> give_vote(@Header("Authorization") String token,
                                     @Field("candidate_id") int candidate_id);

    @FormUrlEncoded
    @GET(AppConstant.ENDPOINT.CANDIDATE_LIST)
    Call<CandidateListResponse> candidate_list(@Header("Authorization") String token,
                                               @Field("candidate_id") String candidate_list);


    /* Scholarship8*/


    @FormUrlEncoded
    @POST(AppConstant.ENDPOINT.ADD_SCHOLARSHIP)
    Call<AddScholarship> add_scholarship(@Header("Authorization") String token,
                                         @Field("scholarship_name") String scholarship_name);

    @FormUrlEncoded
    @POST(AppConstant.ENDPOINT.APPLY_FOR_SCHOLARSHIP)
    Call<ApplyForScholarshipResponse> apply_for_scholarship(@Header("Authorization") String token,
                                                            @Field("scholarship_id") String scholarship_id,
                                                            @Field("full_name") String full_name,
                                                            @Field("email") String email,
                                                            @Field("mobile") String mobile,
                                                            @Field("dob") String dob,
                                                            @Field("gender") String gender,
                                                            @Field("profile_img") String profile_img,
                                                            @Field("verification_id") String verification_id,
                                                            @Field("verification_id_num") String verification_id_num,
                                                            @Field("images") String images);

    @FormUrlEncoded
    @POST(AppConstant.ENDPOINT.GET_SCHOLARSHIP_AWARDS)
    Call<ScholarshipAwardResponse> get_scholarship_award(@Header("Authorization") String token,
                                                         @Field("is_month_wise") String monthWise);

    @FormUrlEncoded
    @POST(ApiClient.ENDPOINT.REGISTER)
    Call<RegistrationResponse> registration(@Field("user_role") String user_role,
                                            @Field("full_name") String full_name,
                                            @Field("email") String email,
                                            @Field("password") String password,
                                            @Field("mobile") String mobile);
    }



