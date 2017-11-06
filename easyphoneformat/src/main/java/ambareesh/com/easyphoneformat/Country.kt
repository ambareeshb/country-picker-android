package ambareesh.com.easyphoneformat

import android.content.Context
import android.telephony.TelephonyManager
import java.util.*

class Country(code: String = "",  var name: String = "",
               var dialCode: String = "",  var flag: Int = -1) {

    var code: String = code
        set(code) {
            if (name.isEmpty()) {
                name = Locale("", code).displayName
            }
        }


//    fun loadFlagByCode(context: Context) {
//        if (this.flag != -1)
//            return
//
//        try {
//            this.flag = context.resources
//                    .getIdentifier("flag_" + this.code!!.toLowerCase(Locale.ENGLISH), "drawable",
//                            context.packageName)
//        } catch (e: Exception) {
//            e.printStackTrace()
//            this.flag = -1
//        }
//
//    }



    companion object {
        val COUNTRIES = arrayOf(Country("AD", "Andorra", "+376", R.drawable.flag_ad), Country("AE", "United Arab Emirates", "+971", R.drawable.flag_ae), Country("AF", "Afghanistan", "+93", R.drawable.flag_af), Country("AG", "Antigua and Barbuda", "+1", R.drawable.flag_ag), Country("AI", "Anguilla", "+1", R.drawable.flag_ai), Country("AL", "Albania", "+355", R.drawable.flag_al), Country("AM", "Armenia", "+374", R.drawable.flag_am), Country("AO", "Angola", "+244", R.drawable.flag_ao), Country("AQ", "Antarctica", "+672", R.drawable.flag_aq), Country("AR", "Argentina", "+54", R.drawable.flag_ar), Country("AS", "AmericanSamoa", "+1", R.drawable.flag_as), Country("AT", "Austria", "+43", R.drawable.flag_at), Country("AU", "Australia", "+61", R.drawable.flag_au), Country("AW", "Aruba", "+297", R.drawable.flag_aw), Country("AX", "Åland Islands", "+358", R.drawable.flag_ax), Country("AZ", "Azerbaijan", "+994", R.drawable.flag_az), Country("BA", "Bosnia and Herzegovina", "+387", R.drawable.flag_ba), Country("BB", "Barbados", "+1", R.drawable.flag_bb), Country("BD", "Bangladesh", "+880", R.drawable.flag_bd), Country("BE", "Belgium", "+32", R.drawable.flag_be), Country("BF", "Burkina Faso", "+226", R.drawable.flag_bf), Country("BG", "Bulgaria", "+359", R.drawable.flag_bg), Country("BH", "Bahrain", "+973", R.drawable.flag_bh), Country("BI", "Burundi", "+257", R.drawable.flag_bi), Country("BJ", "Benin", "+229", R.drawable.flag_bj), Country("BL", "Saint Barthélemy", "+590", R.drawable.flag_bl), Country("BM", "Bermuda", "+1", R.drawable.flag_bm), Country("BN", "Brunei Darussalam", "+673", R.drawable.flag_bn), Country("BO", "Bolivia, Plurinational State of", "+591", R.drawable.flag_bo), Country("BQ", "Bonaire", "+599", R.drawable.flag_bq), Country("BR", "Brazil", "+55", R.drawable.flag_br), Country("BS", "Bahamas", "+1", R.drawable.flag_bs), Country("BT", "Bhutan", "+975", R.drawable.flag_bt), Country("BV", "Bouvet Island", "+47", R.drawable.flag_bv), Country("BW", "Botswana", "+267", R.drawable.flag_bw), Country("BY", "Belarus", "+375", R.drawable.flag_by), Country("BZ", "Belize", "+501", R.drawable.flag_bz), Country("CA", "Canada", "+1", R.drawable.flag_ca), Country("CC", "Cocos (Keeling) Islands", "+61", R.drawable.flag_cc), Country("CD", "Congo, The Democratic Republic of the", "+243", R.drawable.flag_cd), Country("CF", "Central African Republic", "+236", R.drawable.flag_cf), Country("CG", "Congo", "+242", R.drawable.flag_cg), Country("CH", "Switzerland", "+41", R.drawable.flag_ch), Country("CI", "Ivory Coast", "+225", R.drawable.flag_ci), Country("CK", "Cook Islands", "+682", R.drawable.flag_ck), Country("CL", "Chile", "+56", R.drawable.flag_cl), Country("CM", "Cameroon", "+237", R.drawable.flag_cm), Country("CN", "China", "+86", R.drawable.flag_cn), Country("CO", "Colombia", "+57", R.drawable.flag_co), Country("CR", "Costa Rica", "+506", R.drawable.flag_cr), Country("CU", "Cuba", "+53", R.drawable.flag_cu), Country("CV", "Cape Verde", "+238", R.drawable.flag_cv), Country("CW", "Curacao", "+599", R.drawable.flag_cw), Country("CX", "Christmas Island", "+61", R.drawable.flag_cx), Country("CY", "Cyprus", "+357", R.drawable.flag_cy), Country("CZ", "Czech Republic", "+420", R.drawable.flag_cz), Country("DE", "Germany", "+49", R.drawable.flag_de), Country("DJ", "Djibouti", "+253", R.drawable.flag_dj), Country("DK", "Denmark", "+45", R.drawable.flag_dk), Country("DM", "Dominica", "+1", R.drawable.flag_dm), Country("DO", "Dominican Republic", "+1", R.drawable.flag_do), Country("DZ", "Algeria", "+213", R.drawable.flag_dz), Country("EC", "Ecuador", "+593", R.drawable.flag_ec), Country("EE", "Estonia", "+372", R.drawable.flag_ee), Country("EG", "Egypt", "+20", R.drawable.flag_eg), Country("EH", "Western Sahara", "+212", R.drawable.flag_eh), Country("ER", "Eritrea", "+291", R.drawable.flag_er), Country("ES", "Spain", "+34", R.drawable.flag_es), Country("ET", "Ethiopia", "+251", R.drawable.flag_et), Country("FI", "Finland", "+358", R.drawable.flag_fi), Country("FJ", "Fiji", "+679", R.drawable.flag_fj), Country("FK", "Falkland Islands (Malvinas)", "+500", R.drawable.flag_fk), Country("FM", "Micronesia, Federated States of", "+691", R.drawable.flag_fm), Country("FO", "Faroe Islands", "+298", R.drawable.flag_fo), Country("FR", "France", "+33", R.drawable.flag_fr), Country("GA", "Gabon", "+241", R.drawable.flag_ga), Country("GB", "United Kingdom", "+44", R.drawable.flag_gb), Country("GD", "Grenada", "+1", R.drawable.flag_gd), Country("GE", "Georgia", "+995", R.drawable.flag_ge), Country("GF", "French Guiana", "+594", R.drawable.flag_gf), Country("GG", "Guernsey", "+44", R.drawable.flag_gg), Country("GH", "Ghana", "+233", R.drawable.flag_gh), Country("GI", "Gibraltar", "+350", R.drawable.flag_gi), Country("GL", "Greenland", "+299", R.drawable.flag_gl), Country("GM", "Gambia", "+220", R.drawable.flag_gm), Country("GN", "Guinea", "+224", R.drawable.flag_gn), Country("GP", "Guadeloupe", "+590", R.drawable.flag_gp), Country("GQ", "Equatorial Guinea", "+240", R.drawable.flag_gq), Country("GR", "Greece", "+30", R.drawable.flag_gr), Country("GS", "South Georgia and the South Sandwich Islands", "+500", R.drawable.flag_gs), Country("GT", "Guatemala", "+502", R.drawable.flag_gt), Country("GU", "Guam", "+1", R.drawable.flag_gu), Country("GW", "Guinea-Bissau", "+245", R.drawable.flag_gw), Country("GY", "Guyana", "+595", R.drawable.flag_gy), Country("HK", "Hong Kong", "+852", R.drawable.flag_hk), Country("HM", "Heard Island and McDonald Islands", "", R.drawable.flag_hm), Country("HN", "Honduras", "+504", R.drawable.flag_hn), Country("HR", "Croatia", "+385", R.drawable.flag_hr), Country("HT", "Haiti", "+509", R.drawable.flag_ht), Country("HU", "Hungary", "+36", R.drawable.flag_hu), Country("ID", "Indonesia", "+62", R.drawable.flag_id), Country("IE", "Ireland", "+353", R.drawable.flag_ie), Country("IL", "Israel", "+972", R.drawable.flag_il), Country("IM", "Isle of Man", "+44", R.drawable.flag_im), Country("IN", "India", "+91", R.drawable.flag_in), Country("IO", "British Indian Ocean Territory", "+246", R.drawable.flag_io), Country("IQ", "Iraq", "+964", R.drawable.flag_iq), Country("IR", "Iran, Islamic Republic of", "+98", R.drawable.flag_ir), Country("IS", "Iceland", "+354", R.drawable.flag_is), Country("IT", "Italy", "+39", R.drawable.flag_it), Country("JE", "Jersey", "+44", R.drawable.flag_je), Country("JM", "Jamaica", "+1", R.drawable.flag_jm), Country("JO", "Jordan", "+962", R.drawable.flag_jo), Country("JP", "Japan", "+81", R.drawable.flag_jp), Country("KE", "Kenya", "+254", R.drawable.flag_ke), Country("KG", "Kyrgyzstan", "+996", R.drawable.flag_kg), Country("KH", "Cambodia", "+855", R.drawable.flag_kh), Country("KI", "Kiribati", "+686", R.drawable.flag_ki), Country("KM", "Comoros", "+269", R.drawable.flag_km), Country("KN", "Saint Kitts and Nevis", "+1", R.drawable.flag_kn), Country("KP", "North Korea", "+850", R.drawable.flag_kp), Country("KR", "South Korea", "+82", R.drawable.flag_kr), Country("KW", "Kuwait", "+965", R.drawable.flag_kw), Country("KY", "Cayman Islands", "+345", R.drawable.flag_ky), Country("KZ", "Kazakhstan", "+7", R.drawable.flag_kz), Country("LA", "Lao People's Democratic Republic", "+856", R.drawable.flag_la), Country("LB", "Lebanon", "+961", R.drawable.flag_lb), Country("LC", "Saint Lucia", "+1", R.drawable.flag_lc), Country("LI", "Liechtenstein", "+423", R.drawable.flag_li), Country("LK", "Sri Lanka", "+94", R.drawable.flag_lk), Country("LR", "Liberia", "+231", R.drawable.flag_lr), Country("LS", "Lesotho", "+266", R.drawable.flag_ls), Country("LT", "Lithuania", "+370", R.drawable.flag_lt), Country("LU", "Luxembourg", "+352", R.drawable.flag_lu), Country("LV", "Latvia", "+371", R.drawable.flag_lv), Country("LY", "Libyan Arab Jamahiriya", "+218", R.drawable.flag_ly), Country("MA", "Morocco", "+212", R.drawable.flag_ma), Country("MC", "Monaco", "+377", R.drawable.flag_mc), Country("MD", "Moldova, Republic of", "+373", R.drawable.flag_md), Country("ME", "Montenegro", "+382", R.drawable.flag_me), Country("MF", "Saint Martin", "+590", R.drawable.flag_mf), Country("MG", "Madagascar", "+261", R.drawable.flag_mg), Country("MH", "Marshall Islands", "+692", R.drawable.flag_mh), Country("MK", "Macedonia, The Former Yugoslav Republic of", "+389", R.drawable.flag_mk), Country("ML", "Mali", "+223", R.drawable.flag_ml), Country("MM", "Myanmar", "+95", R.drawable.flag_mm), Country("MN", "Mongolia", "+976", R.drawable.flag_mn), Country("MO", "Macao", "+853", R.drawable.flag_mo), Country("MP", "Northern Mariana Islands", "+1", R.drawable.flag_mp), Country("MQ", "Martinique", "+596", R.drawable.flag_mq), Country("MR", "Mauritania", "+222", R.drawable.flag_mr), Country("MS", "Montserrat", "+1", R.drawable.flag_ms), Country("MT", "Malta", "+356", R.drawable.flag_mt), Country("MU", "Mauritius", "+230", R.drawable.flag_mu), Country("MV", "Maldives", "+960", R.drawable.flag_mv), Country("MW", "Malawi", "+265", R.drawable.flag_mw), Country("MX", "Mexico", "+52", R.drawable.flag_mx), Country("MY", "Malaysia", "+60", R.drawable.flag_my), Country("MZ", "Mozambique", "+258", R.drawable.flag_mz), Country("NA", "Namibia", "+264", R.drawable.flag_na), Country("NC", "New Caledonia", "+687", R.drawable.flag_nc), Country("NE", "Niger", "+227", R.drawable.flag_ne), Country("NF", "Norfolk Island", "+672", R.drawable.flag_nf), Country("NG", "Nigeria", "+234", R.drawable.flag_ng), Country("NI", "Nicaragua", "+505", R.drawable.flag_ni), Country("NL", "Netherlands", "+31", R.drawable.flag_nl), Country("NO", "Norway", "+47", R.drawable.flag_no), Country("NP", "Nepal", "+977", R.drawable.flag_np), Country("NR", "Nauru", "+674", R.drawable.flag_nr), Country("NU", "Niue", "+683", R.drawable.flag_nu), Country("NZ", "New Zealand", "+64", R.drawable.flag_nz), Country("OM", "Oman", "+968", R.drawable.flag_om), Country("PA", "Panama", "+507", R.drawable.flag_pa), Country("PE", "Peru", "+51", R.drawable.flag_pe), Country("PF", "French Polynesia", "+689", R.drawable.flag_pf), Country("PG", "Papua New Guinea", "+675", R.drawable.flag_pg), Country("PH", "Philippines", "+63", R.drawable.flag_ph), Country("PK", "Pakistan", "+92", R.drawable.flag_pk), Country("PL", "Poland", "+48", R.drawable.flag_pl), Country("PM", "Saint Pierre and Miquelon", "+508", R.drawable.flag_pm), Country("PN", "Pitcairn", "+872", R.drawable.flag_pn), Country("PR", "Puerto Rico", "+1", R.drawable.flag_pr), Country("PS", "Palestinian Territory, Occupied", "+970", R.drawable.flag_ps), Country("PT", "Portugal", "+351", R.drawable.flag_pt), Country("PW", "Palau", "+680", R.drawable.flag_pw), Country("PY", "Paraguay", "+595", R.drawable.flag_py), Country("QA", "Qatar", "+974", R.drawable.flag_qa), Country("RE", "Réunion", "+262", R.drawable.flag_re), Country("RO", "Romania", "+40", R.drawable.flag_ro), Country("RS", "Serbia", "+381", R.drawable.flag_rs), Country("RU", "Russia", "+7", R.drawable.flag_ru), Country("RW", "Rwanda", "+250", R.drawable.flag_rw), Country("SA", "Saudi Arabia", "+966", R.drawable.flag_sa), Country("SB", "Solomon Islands", "+677", R.drawable.flag_sb), Country("SC", "Seychelles", "+248", R.drawable.flag_sc), Country("SD", "Sudan", "+249", R.drawable.flag_sd), Country("SE", "Sweden", "+46", R.drawable.flag_se), Country("SG", "Singapore", "+65", R.drawable.flag_sg), Country("SH", "Saint Helena, Ascension and Tristan Da Cunha", "+290", R.drawable.flag_sh), Country("SI", "Slovenia", "+386", R.drawable.flag_si), Country("SJ", "Svalbard and Jan Mayen", "+47", R.drawable.flag_sj), Country("SK", "Slovakia", "+421", R.drawable.flag_sk), Country("SL", "Sierra Leone", "+232", R.drawable.flag_sl), Country("SM", "San Marino", "+378", R.drawable.flag_sm), Country("SN", "Senegal", "+221", R.drawable.flag_sn), Country("SO", "Somalia", "+252", R.drawable.flag_so), Country("SR", "Suriname", "+597", R.drawable.flag_sr), Country("SS", "South Sudan", "+211", R.drawable.flag_ss), Country("ST", "Sao Tome and Principe", "+239", R.drawable.flag_st), Country("SV", "El Salvador", "+503", R.drawable.flag_sv), Country("SX", "  Sint Maarten", "+1", R.drawable.flag_sx), Country("SY", "Syrian Arab Republic", "+963", R.drawable.flag_sy), Country("SZ", "Swaziland", "+268", R.drawable.flag_sz), Country("TC", "Turks and Caicos Islands", "+1", R.drawable.flag_tc), Country("TD", "Chad", "+235", R.drawable.flag_td), Country("TF", "French Southern Territories", "+262", R.drawable.flag_tf), Country("TG", "Togo", "+228", R.drawable.flag_tg), Country("TH", "Thailand", "+66", R.drawable.flag_th), Country("TJ", "Tajikistan", "+992", R.drawable.flag_tj), Country("TK", "Tokelau", "+690", R.drawable.flag_tk), Country("TL", "East Timor", "+670", R.drawable.flag_tl), Country("TM", "Turkmenistan", "+993", R.drawable.flag_tm), Country("TN", "Tunisia", "+216", R.drawable.flag_tn), Country("TO", "Tonga", "+676", R.drawable.flag_to), Country("TR", "Turkey", "+90", R.drawable.flag_tr), Country("TT", "Trinidad and Tobago", "+1", R.drawable.flag_tt), Country("TV", "Tuvalu", "+688", R.drawable.flag_tv), Country("TW", "Taiwan", "+886", R.drawable.flag_tw), Country("TZ", "Tanzania, United Republic of", "+255", R.drawable.flag_tz), Country("UA", "Ukraine", "+380", R.drawable.flag_ua), Country("UG", "Uganda", "+256", R.drawable.flag_ug), Country("UM", "U.S. Minor Outlying Islands", "", R.drawable.flag_um), Country("US", "United States", "+1", R.drawable.flag_us), Country("UY", "Uruguay", "+598", R.drawable.flag_uy), Country("UZ", "Uzbekistan", "+998", R.drawable.flag_uz), Country("VA", "Holy See (Vatican City State)", "+379", R.drawable.flag_va), Country("VC", "Saint Vincent and the Grenadines", "+1", R.drawable.flag_vc), Country("VE", "Venezuela, Bolivarian Republic of", "+58", R.drawable.flag_ve), Country("VG", "Virgin Islands, British", "+1", R.drawable.flag_vg), Country("VI", "Virgin Islands, U.S.", "+1", R.drawable.flag_vi), Country("VN", "Viet Nam", "+84", R.drawable.flag_vn), Country("VU", "Vanuatu", "+678", R.drawable.flag_vu), Country("WF", "Wallis and Futuna", "+681", R.drawable.flag_wf), Country("WS", "Samoa", "+685", R.drawable.flag_ws), Country("XK", "Kosovo", "+383", R.drawable.flag_xk), Country("YE", "Yemen", "+967", R.drawable.flag_ye), Country("YT", "Mayotte", "+262", R.drawable.flag_yt), Country("ZA", "South Africa", "+27", R.drawable.flag_za), Country("ZM", "Zambia", "+260", R.drawable.flag_zm), Country("ZW", "Zimbabwe", "+263", R.drawable.flag_zw))


        fun getCountryByISO(countryIsoCode: String): Country? {

            val c = Country(code = countryIsoCode.toUpperCase())
            c.code = countryIsoCode

            val i = Arrays.binarySearch(COUNTRIES, c, ISOCodeComparator())

            return if (i < 0) {
                null
            } else {
                COUNTRIES[i]
            }
        }

        fun getCountryByName(countryName: String): Country? {
            // Because the data we have is sorted by ISO codes and not by names, we must check all
            // countries one by one

            for (c in COUNTRIES) {
                if (countryName == c.name) {
                    return c
                }
            }
            return null
        }

        fun getCountryByLocale(locale: Locale): Country? {
            val countryIsoCode = locale.isO3Country.substring(0, 2).toLowerCase()
            return Country.getCountryByISO(countryIsoCode)
        }

        fun getCountryFromSIM(context: Context): Country? {
            val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            return if (telephonyManager.simState != TelephonyManager.SIM_STATE_ABSENT) {
                Country.getCountryByISO(telephonyManager.simCountryIso)
            } else null
        }
    }
    /*
    * COMPARATORS
    */

    class ISOCodeComparator : Comparator<Country> {
        override fun compare(country: Country, t1: Country): Int {
            return country.code!!.compareTo(t1.code!!)
        }
    }


    class NameComparator : Comparator<Country> {
        override fun compare(country: Country, t1: Country): Int {
            return country.name!!.compareTo(t1.name!!)
        }
    }
    /**
     * Listener for country related operations.
     */
    interface CountryListener{
        fun countrySelected(country:Country)
    }
}