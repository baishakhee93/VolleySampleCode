package com.baishakhee.volleysamplecode

import com.google.gson.annotations.SerializedName

class MatchModel {

    @SerializedName("nameValuePairs" )
    var nameValuePairs : NameValuePairs?         = NameValuePairs()

    class NameValuePairs {
        @SerializedName("apikey" )
        var apikey : String?         = null


        @SerializedName("data"   )
        var data   : Data = Data()

        class Data {
            @SerializedName("values"        )
            var values        : ArrayList<DataValues>? = arrayListOf()

            class DataValues {
                @SerializedName("nameValuePairs" )
                var dataValues : DataValuesPairs?         = DataValuesPairs()

                class DataValuesPairs {
                    @SerializedName("id"        )
                    var id        : String? = null
                    @SerializedName("name"      )
                    var name      : String? = null
                    @SerializedName("startDate" )
                    var startDate : String? = null
                    @SerializedName("endDate"   )
                    var endDate   : String? = null
                    @SerializedName("odi"       )
                    var odi       : Int?    = null
                    @SerializedName("t20"       )
                    var t20       : Int?    = null
                    @SerializedName("test"      )
                    var test      : Int?    = null
                    @SerializedName("squads"    )
                    var squads    : Int?    = null
                    @SerializedName("matches"   )
                    var matches   : Int?    = null
                }


            }



        }

        //var data   : ArrayList<Data> = arrayListOf()
        @SerializedName("status" ) var status : String?         = null
        @SerializedName("info"   ) var info   : Info?           = Info()

        class Info {
            @SerializedName("nameValuePairs" )
            var nameValuePairsInfo : NameValuePairsInfo?         = NameValuePairsInfo()

            class NameValuePairsInfo {
                @SerializedName("hitsToday"  ) 
                var hitsToday  : Int?    = null
                @SerializedName("hitsUsed"   )
                var hitsUsed   : Int?    = null
                @SerializedName("hitsLimit"  )
                var hitsLimit  : Int?    = null
                @SerializedName("credits"    )
                var credits    : Int?    = null
                @SerializedName("server"     )
                var server     : Int?    = null
                @SerializedName("offsetRows" )
                var offsetRows : Int?    = null
                @SerializedName("totalRows"  ) var totalRows  : Int?    = null
                @SerializedName("queryTime"  ) var queryTime  : Double? = null
                @SerializedName("s"          ) var s          : Int?    = null
                @SerializedName("cache"      ) var cache      : Int?    = null
            }


        
        }
    }


}