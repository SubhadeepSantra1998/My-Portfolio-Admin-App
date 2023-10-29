package com.example.myportfolioadminapp.common.util

object ApiConstants {

    const val BASE_URL = "http://192.168.0.111:8080/v1/"
    const val VERSION = "v1/"
    const val LOGIN = "auth/users/signin"

    const val ADD = "add"
    const val ALL = "all"
    const val UPDATE = "update"
    const val DELETE = "delete"

    const val MY_SKILL_ALL = "my-skill/all"

//    const val MY_SKILL_CATEGORY = "my-skill/category/all"

    const val ADD_MY_SKILL = "my-skill/add"

    const val UPDATE_MY_SKILL = "my-skill/update"

    const val DELETE_MY_SKILL = "my-skill/delete"


    //final
    const val CATEGORY = "category"


    // education
    const val MY_EDUCATION = "my-education"
    const val MY_EDUCATION_CATEGORY = "$MY_EDUCATION/$CATEGORY"

    const val ALL_MY_EDUCATION = "$MY_EDUCATION/$ALL"
    const val DELETE_MY_EDUCATION = "$MY_EDUCATION/$DELETE"

    const val ALL_EDUCATION_CATEGORY = "$MY_EDUCATION_CATEGORY/$ALL"
    const val ADD_EDUCATION_CATEGORY = "$MY_EDUCATION_CATEGORY/$ADD"
    const val DELETE_EDUCATION_CATEGORY = "$MY_EDUCATION_CATEGORY/$DELETE"
    const val UPDATE_EDUCATION_CATEGORY = "$MY_EDUCATION_CATEGORY/$UPDATE"

    //skill
    const val MY_SKILL = "my-skill"
    const val MY_SKILL_CATEGORY = "$MY_SKILL/$CATEGORY"


    const val ALL_SKILL_CATEGORY = "$MY_SKILL_CATEGORY/$ALL"
    const val ADD_SKILL_CATEGORY = "$MY_SKILL_CATEGORY/$ADD"
    const val DELETE_SKILL_CATEGORY = "$MY_SKILL_CATEGORY/$DELETE"
    const val UPDATE_SKILL_CATEGORY = "$MY_SKILL/$CATEGORY/$UPDATE"
}