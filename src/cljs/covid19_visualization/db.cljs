(ns covid19-visualization.db)

(def default-db
  {}
  #_{::countries [{:Country "Burkina Faso", :Slug "burkina-faso", :ISO2 "BF"}
                {:Country "Christmas Island", :Slug "christmas-island", :ISO2 "CX"}
                {:Country "Montenegro", :Slug "montenegro", :ISO2 "ME"}
                {:Country "Nicaragua", :Slug "nicaragua", :ISO2 "NI"}
                {:Country "Tanzania, United Republic of", :Slug "tanzania", :ISO2 "TZ"}
                {:Country "Pitcairn", :Slug "pitcairn", :ISO2 "PN"}
                {:Country "Angola", :Slug "angola", :ISO2 "AO"}
                {:Country "Dominican Republic", :Slug "dominican-republic", :ISO2 "DO"}
                {:Country "Gibraltar", :Slug "gibraltar", :ISO2 "GI"}
                {:Country "Argentina", :Slug "argentina", :ISO2 "AR"}
                {:Country "India", :Slug "india", :ISO2 "IN"}
                {:Country "Mongolia", :Slug "mongolia", :ISO2 "MN"}
                {:Country "Saudi Arabia", :Slug "saudi-arabia", :ISO2 "SA"}
                {:Country "Brazil", :Slug "brazil", :ISO2 "BR"}
                {:Country "Moldova", :Slug "moldova", :ISO2 "MD"}
                {:Country "New Zealand", :Slug "new-zealand", :ISO2 "NZ"}
                {:Country "Seychelles", :Slug "seychelles", :ISO2 "SC"}
                {:Country "Cook Islands", :Slug "cook-islands", :ISO2 "CK"}
                {:Country "Norway", :Slug "norway", :ISO2 "NO"}
                {:Country "Sri Lanka", :Slug "sri-lanka", :ISO2 "LK"}
                {:Country "Venezuela (Bolivarian Republic)", :Slug "venezuela", :ISO2 "VE"}
                {:Country "British Virgin Islands",
                 :Slug "british-virgin-islands",
                 :ISO2 "VG"}
                {:Country "Iraq", :Slug "iraq", :ISO2 "IQ"}
                {:Country "Hungary", :Slug "hungary", :ISO2 "HU"}
                {:Country "Russian Federation", :Slug "russia", :ISO2 "RU"}
                {:Country "Somalia", :Slug "somalia", :ISO2 "SO"}
                {:Country "Tokelau", :Slug "tokelau", :ISO2 "TK"}
                {:Country "France", :Slug "france", :ISO2 "FR"}
                {:Country "Gambia", :Slug "gambia", :ISO2 "GM"}
                {:Country "South Sudan", :Slug "south-sudan", :ISO2 "SS"}
                {:Country "Aruba", :Slug "aruba", :ISO2 "AW"}
                {:Country "Austria", :Slug "austria", :ISO2 "AT"}
                {:Country "Chile", :Slug "chile", :ISO2 "CL"}
                {:Country "Croatia", :Slug "croatia", :ISO2 "HR"}
                {:Country "Estonia", :Slug "estonia", :ISO2 "EE"}
                {:Country "Ethiopia", :Slug "ethiopia", :ISO2 "ET"}
                {:Country "Lithuania", :Slug "lithuania", :ISO2 "LT"}
                {:Country "American Samoa", :Slug "american-samoa", :ISO2 "AS"}
                {:Country "Central African Republic",
                 :Slug "central-african-republic",
                 :ISO2 "CF"}
                {:Country "Equatorial Guinea", :Slug "equatorial-guinea", :ISO2 "GQ"}
                {:Country "Macedonia, Republic of", :Slug "macedonia", :ISO2 "MK"}
                {:Country "Martinique", :Slug "martinique", :ISO2 "MQ"}
                {:Country "Mauritius", :Slug "mauritius", :ISO2 "MU"}
                {:Country "Western Sahara", :Slug "western-sahara", :ISO2 "EH"}
                {:Country "Albania", :Slug "albania", :ISO2 "AL"}
                {:Country "Brunei Darussalam", :Slug "brunei", :ISO2 "BN"}
                {:Country "Serbia", :Slug "serbia", :ISO2 "RS"}
                {:Country "Italy", :Slug "italy", :ISO2 "IT"}
                {:Country "Micronesia, Federated States of", :Slug "micronesia", :ISO2 "FM"}
                {:Country "Zimbabwe", :Slug "zimbabwe", :ISO2 "ZW"}
                {:Country "Lao PDR", :Slug "lao-pdr", :ISO2 "LA"}
                {:Country "Maldives", :Slug "maldives", :ISO2 "MV"}
                {:Country "Qatar", :Slug "qatar", :ISO2 "QA"}
                {:Country "Sao Tome and Principe", :Slug "sao-tome-and-principe", :ISO2 "ST"}
                {:Country "Sudan", :Slug "sudan", :ISO2 "SD"}
                {:Country "Burundi", :Slug "burundi", :ISO2 "BI"}
                {:Country "Guyana", :Slug "guyana", :ISO2 "GY"}
                {:Country "Hong Kong, SAR China", :Slug "hong-kong-sar-china", :ISO2 "HK"}
                {:Country "Mexico", :Slug "mexico", :ISO2 "MX"}
                {:Country "El Salvador", :Slug "el-salvador", :ISO2 "SV"}
                {:Country "United Kingdom", :Slug "united-kingdom", :ISO2 "GB"}
                {:Country "Cayman Islands", :Slug "cayman-islands", :ISO2 "KY"}
                {:Country "Niger", :Slug "niger", :ISO2 "NE"}
                {:Country "Papua New Guinea", :Slug "papua-new-guinea", :ISO2 "PG"}
                {:Country "Vanuatu", :Slug "vanuatu", :ISO2 "VU"}
                {:Country "Sweden", :Slug "sweden", :ISO2 "SE"}
                {:Country "Grenada", :Slug "grenada", :ISO2 "GD"}
                {:Country "Svalbard and Jan Mayen Islands",
                 :Slug "svalbard-and-jan-mayen-islands",
                 :ISO2 "SJ"}
                {:Country "Turkey", :Slug "turkey", :ISO2 "TR"}
                {:Country "Andorra", :Slug "andorra", :ISO2 "AD"}
                {:Country "Congo (Kinshasa)", :Slug "congo-kinshasa", :ISO2 "CD"}
                {:Country "Holy See (Vatican City State)",
                 :Slug "holy-see-vatican-city-state",
                 :ISO2 "VA"}
                {:Country "Panama", :Slug "panama", :ISO2 "PA"}
                {:Country "Afghanistan", :Slug "afghanistan", :ISO2 "AF"}
                {:Country "Congo (Brazzaville)", :Slug "congo-brazzaville", :ISO2 "CG"}
                {:Country "Czech Republic", :Slug "czech-republic", :ISO2 "CZ"}
                {:Country "Libya", :Slug "libya", :ISO2 "LY"}
                {:Country "Réunion", :Slug "réunion", :ISO2 "RE"}
                {:Country "Bouvet Island", :Slug "bouvet-island", :ISO2 "BV"}
                {:Country "Eritrea", :Slug "eritrea", :ISO2 "ER"}
                {:Country "Netherlands Antilles", :Slug "netherlands-antilles", :ISO2 "AN"}
                {:Country "Singapore", :Slug "singapore", :ISO2 "SG"}
                {:Country "Uganda", :Slug "uganda", :ISO2 "UG"}
                {:Country "Bahrain", :Slug "bahrain", :ISO2 "BH"}
                {:Country "Belarus", :Slug "belarus", :ISO2 "BY"}
                {:Country "Comoros", :Slug "comoros", :ISO2 "KM"}
                {:Country "French Polynesia", :Slug "french-polynesia", :ISO2 "PF"}
                {:Country "Botswana", :Slug "botswana", :ISO2 "BW"}
                {:Country "Côte d'Ivoire", :Slug "cote-divoire", :ISO2 "CI"}
                {:Country "Myanmar", :Slug "myanmar", :ISO2 "MM"}
                {:Country "Nepal", :Slug "nepal", :ISO2 "NP"}
                {:Country "Pakistan", :Slug "pakistan", :ISO2 "PK"}
                {:Country "San Marino", :Slug "san-marino", :ISO2 "SM"}
                {:Country "Slovenia", :Slug "slovenia", :ISO2 "SI"}
                {:Country "Bermuda", :Slug "bermuda", :ISO2 "BM"}
                {:Country "Djibouti", :Slug "djibouti", :ISO2 "DJ"}
                {:Country "Uzbekistan", :Slug "uzbekistan", :ISO2 "UZ"}
                {:Country "Wallis and Futuna Islands",
                 :Slug "wallis-and-futuna-islands",
                 :ISO2 "WF"}
                {:Country "Anguilla", :Slug "anguilla", :ISO2 "AI"}
                {:Country "Israel", :Slug "israel", :ISO2 "IL"}
                {:Country "Japan", :Slug "japan", :ISO2 "JP"}
                {:Country "Tuvalu", :Slug "tuvalu", :ISO2 "TV"}
                {:Country "Cuba", :Slug "cuba", :ISO2 "CU"}
                {:Country "Faroe Islands", :Slug "faroe-islands", :ISO2 "FO"}
                {:Country "Marshall Islands", :Slug "marshall-islands", :ISO2 "MH"}
                {:Country "Mauritania", :Slug "mauritania", :ISO2 "MR"}
                {:Country "New Caledonia", :Slug "new-caledonia", :ISO2 "NC"}
                {:Country "Peru", :Slug "peru", :ISO2 "PE"}
                {:Country "Puerto Rico", :Slug "puerto-rico", :ISO2 "PR"}
                {:Country "Zambia", :Slug "zambia", :ISO2 "ZM"}
                {:Country "Chad", :Slug "chad", :ISO2 "TD"}
                {:Country "Finland", :Slug "finland", :ISO2 "FI"}
                {:Country "Indonesia", :Slug "indonesia", :ISO2 "ID"}
                {:Country "Montserrat", :Slug "montserrat", :ISO2 "MS"}
                {:Country "Dominica", :Slug "dominica", :ISO2 "DM"}
                {:Country "Luxembourg", :Slug "luxembourg", :ISO2 "LU"}
                {:Country "Netherlands", :Slug "netherlands", :ISO2 "NL"}
                {:Country "Costa Rica", :Slug "costa-rica", :ISO2 "CR"}
                {:Country "Falkland Islands (Malvinas)",
                 :Slug "falkland-islands-malvinas",
                 :ISO2 "FK"}
                {:Country "Fiji", :Slug "fiji", :ISO2 "FJ"}
                {:Country "Kazakhstan", :Slug "kazakhstan", :ISO2 "KZ"}
                {:Country "Solomon Islands", :Slug "solomon-islands", :ISO2 "SB"}
                {:Country "Republic of Kosovo", :Slug "kosovo", :ISO2 "XK"}
                {:Country "Ukraine", :Slug "ukraine", :ISO2 "UA"}
                {:Country "United States of America", :Slug "united-states", :ISO2 "US"}
                {:Country "Bolivia", :Slug "bolivia", :ISO2 "BO"}
                {:Country "French Guiana", :Slug "french-guiana", :ISO2 "GF"}
                {:Country "Georgia", :Slug "georgia", :ISO2 "GE"}
                {:Country "Niue", :Slug "niue", :ISO2 "NU"}
                {:Country "Turks and Caicos Islands",
                 :Slug "turks-and-caicos-islands",
                 :ISO2 "TC"}
                {:Country "Antigua and Barbuda", :Slug "antigua-and-barbuda", :ISO2 "AG"}
                {:Country "Azerbaijan", :Slug "azerbaijan", :ISO2 "AZ"}
                {:Country "Benin", :Slug "benin", :ISO2 "BJ"}
                {:Country "British Indian Ocean Territory",
                 :Slug "british-indian-ocean-territory",
                 :ISO2 "IO"}
                {:Country "Cameroon", :Slug "cameroon", :ISO2 "CM"}
                {:Country "Jersey", :Slug "jersey", :ISO2 "JE"}
                {:Country "Kyrgyzstan", :Slug "kyrgyzstan", :ISO2 "KG"}
                {:Country "Macao, SAR China", :Slug "macao-sar-china", :ISO2 "MO"}
                {:Country "Morocco", :Slug "morocco", :ISO2 "MA"}
                {:Country "Lesotho", :Slug "lesotho", :ISO2 "LS"}
                {:Country "Liberia", :Slug "liberia", :ISO2 "LR"}
                {:Country "Mozambique", :Slug "mozambique", :ISO2 "MZ"}
                {:Country "Nauru", :Slug "nauru", :ISO2 "NR"}
                {:Country "Samoa", :Slug "samoa", :ISO2 "WS"}
                {:Country "Yemen", :Slug "yemen", :ISO2 "YE"}
                {:Country "Ghana", :Slug "ghana", :ISO2 "GH"}
                {:Country "Ireland", :Slug "ireland", :ISO2 "IE"}
                {:Country "Madagascar", :Slug "madagascar", :ISO2 "MG"}
                {:Country "Malaysia", :Slug "malaysia", :ISO2 "MY"}
                {:Country "Ecuador", :Slug "ecuador", :ISO2 "EC"}
                {:Country "Greenland", :Slug "greenland", :ISO2 "GL"}
                {:Country "Guam", :Slug "guam", :ISO2 "GU"}
                {:Country "Palau", :Slug "palau", :ISO2 "PW"}
                {:Country "Bangladesh", :Slug "bangladesh", :ISO2 "BD"}
                {:Country "Iceland", :Slug "iceland", :ISO2 "IS"}
                {:Country "Sierra Leone", :Slug "sierra-leone", :ISO2 "SL"}
                {:Country "Switzerland", :Slug "switzerland", :ISO2 "CH"}
                {:Country "Togo", :Slug "togo", :ISO2 "TG"}
                {:Country "Antarctica", :Slug "antarctica", :ISO2 "AQ"}
                {:Country "Cambodia", :Slug "cambodia", :ISO2 "KH"}
                {:Country "Korea (South)", :Slug "korea-south", :ISO2 "KR"}
                {:Country "Northern Mariana Islands",
                 :Slug "northern-mariana-islands",
                 :ISO2 "MP"}
                {:Country "Taiwan, Republic of China", :Slug "taiwan", :ISO2 "TW"}
                {:Country "Canada", :Slug "canada", :ISO2 "CA"}
                {:Country "Portugal", :Slug "portugal", :ISO2 "PT"}
                {:Country "Belize", :Slug "belize", :ISO2 "BZ"}
                {:Country "Bhutan", :Slug "bhutan", :ISO2 "BT"}
                {:Country "Kenya", :Slug "kenya", :ISO2 "KE"}
                {:Country "Viet Nam", :Slug "vietnam", :ISO2 "VN"}
                {:Country "Mayotte", :Slug "mayotte", :ISO2 "YT"}
                {:Country "Namibia", :Slug "namibia", :ISO2 "NA"}
                {:Country "Heard and Mcdonald Islands",
                 :Slug "heard-and-mcdonald-islands",
                 :ISO2 "HM"}
                {:Country "Iran, Islamic Republic of", :Slug "iran", :ISO2 "IR"}
                {:Country "Kuwait", :Slug "kuwait", :ISO2 "KW"}
                {:Country "Syrian Arab Republic (Syria)", :Slug "syria", :ISO2 "SY"}
                {:Country "Thailand", :Slug "thailand", :ISO2 "TH"}
                {:Country "Bahamas", :Slug "bahamas", :ISO2 "BS"}
                {:Country "Nigeria", :Slug "nigeria", :ISO2 "NG"}
                {:Country "Palestinian Territory", :Slug "palestine", :ISO2 "PS"}
                {:Country "Tonga", :Slug "tonga", :ISO2 "TO"}
                {:Country "Colombia", :Slug "colombia", :ISO2 "CO"}
                {:Country "Guinea", :Slug "guinea", :ISO2 "GN"}
                {:Country "Algeria", :Slug "algeria", :ISO2 "DZ"}
                {:Country "Belgium", :Slug "belgium", :ISO2 "BE"}
                {:Country "China", :Slug "china", :ISO2 "CN"}
                {:Country "Philippines", :Slug "philippines", :ISO2 "PH"}
                {:Country "Armenia", :Slug "armenia", :ISO2 "AM"}
                {:Country "Liechtenstein", :Slug "liechtenstein", :ISO2 "LI"}
                {:Country "Cyprus", :Slug "cyprus", :ISO2 "CY"}
                {:Country "Germany", :Slug "germany", :ISO2 "DE"}
                {:Country "Jordan", :Slug "jordan", :ISO2 "JO"}
                {:Country "Slovakia", :Slug "slovakia", :ISO2 "SK"}
                {:Country "Guinea-Bissau", :Slug "guinea-bissau", :ISO2 "GW"}
                {:Country "Paraguay", :Slug "paraguay", :ISO2 "PY"}
                {:Country "Saint-Barthélemy", :Slug "saint-barthélemy", :ISO2 "BL"}
                {:Country "South Africa", :Slug "south-africa", :ISO2 "ZA"}
                {:Country "South Georgia and the South Sandwich Islands",
                 :Slug "south-georgia-and-the-south-sandwich-islands",
                 :ISO2 "GS"}
                {:Country "Denmark", :Slug "denmark", :ISO2 "DK"}
                {:Country "Guadeloupe", :Slug "guadeloupe", :ISO2 "GP"}
                {:Country "Guernsey", :Slug "guernsey", :ISO2 "GG"}
                {:Country "Isle of Man", :Slug "isle-of-man", :ISO2 "IM"}
                {:Country "Saint Helena", :Slug "saint-helena", :ISO2 "SH"}
                {:Country "Spain", :Slug "spain", :ISO2 "ES"}
                {:Country "Swaziland", :Slug "swaziland", :ISO2 "SZ"}
                {:Country "Australia", :Slug "australia", :ISO2 "AU"}
                {:Country "French Southern Territories",
                 :Slug "french-southern-territories",
                 :ISO2 "TF"}
                {:Country "Suriname", :Slug "suriname", :ISO2 "SR"}
                {:Country "Timor-Leste", :Slug "timor-leste", :ISO2 "TL"}
                {:Country "US Minor Outlying Islands",
                 :Slug "us-minor-outlying-islands",
                 :ISO2 "UM"}
                {:Country "Barbados", :Slug "barbados", :ISO2 "BB"}
                {:Country "Bulgaria", :Slug "bulgaria", :ISO2 "BG"}
                {:Country "Jamaica", :Slug "jamaica", :ISO2 "JM"}
                {:Country "Malta", :Slug "malta", :ISO2 "MT"}
                {:Country "Norfolk Island", :Slug "norfolk-island", :ISO2 "NF"}
                {:Country "Poland", :Slug "poland", :ISO2 "PL"}
                {:Country "Guatemala", :Slug "guatemala", :ISO2 "GT"}
                {:Country "Mali", :Slug "mali", :ISO2 "ML"}
                {:Country "Oman", :Slug "oman", :ISO2 "OM"}
                {:Country "Rwanda", :Slug "rwanda", :ISO2 "RW"}
                {:Country "Honduras", :Slug "honduras", :ISO2 "HN"}
                {:Country "Saint Pierre and Miquelon",
                 :Slug "saint-pierre-and-miquelon",
                 :ISO2 "PM"}
                {:Country "Saint Vincent and Grenadines",
                 :Slug "saint-vincent-and-the-grenadines",
                 :ISO2 "VC"}
                {:Country "Trinidad and Tobago", :Slug "trinidad-and-tobago", :ISO2 "TT"}
                {:Country "Tajikistan", :Slug "tajikistan", :ISO2 "TJ"}
                {:Country "Turkmenistan", :Slug "turkmenistan", :ISO2 "TM"}
                {:Country "Cocos (Keeling) Islands",
                 :Slug "cocos-keeling-islands",
                 :ISO2 "CC"}
                {:Country "Greece", :Slug "greece", :ISO2 "GR"}
                {:Country "Haiti", :Slug "haiti", :ISO2 "HT"}
                {:Country "Virgin Islands, US", :Slug "virgin-islands", :ISO2 "VI"}
                {:Country "Malawi", :Slug "malawi", :ISO2 "MW"}
                {:Country "Saint-Martin (French part)",
                 :Slug "saint-martin-french-part",
                 :ISO2 "MF"}
                {:Country "United Arab Emirates", :Slug "united-arab-emirates", :ISO2 "AE"}
                {:Country "Cape Verde", :Slug "cape-verde", :ISO2 "CV"}
                {:Country "Korea (North)", :Slug "korea-north", :ISO2 "KP"}
                {:Country "ALA Aland Islands", :Slug "ala-aland-islands", :ISO2 "AX"}
                {:Country "Egypt", :Slug "egypt", :ISO2 "EG"}
                {:Country "Kiribati", :Slug "kiribati", :ISO2 "KI"}
                {:Country "Monaco", :Slug "monaco", :ISO2 "MC"}
                {:Country "Saint Kitts and Nevis", :Slug "saint-kitts-and-nevis", :ISO2 "KN"}
                {:Country "Senegal", :Slug "senegal", :ISO2 "SN"}
                {:Country "Tunisia", :Slug "tunisia", :ISO2 "TN"}
                {:Country "Uruguay", :Slug "uruguay", :ISO2 "UY"}
                {:Country "Bosnia and Herzegovina",
                 :Slug "bosnia-and-herzegovina",
                 :ISO2 "BA"}
                {:Country "Gabon", :Slug "gabon", :ISO2 "GA"}
                {:Country "Latvia", :Slug "latvia", :ISO2 "LV"}
                {:Country "Lebanon", :Slug "lebanon", :ISO2 "LB"}
                {:Country "Romania", :Slug "romania", :ISO2 "RO"}
                {:Country "Saint Lucia", :Slug "saint-lucia", :ISO2 "LC"}]})
