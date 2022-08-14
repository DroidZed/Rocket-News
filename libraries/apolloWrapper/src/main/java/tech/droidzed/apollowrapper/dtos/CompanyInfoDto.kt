package tech.droidzed.apollowrapper.dtos

data class CompanyLinksDto(
	var twitter: String = "",
	var website: String = "",
	var elon_twitter: String = "",
	var flickr: String = "",
)

data class CompanyHeadQuarters(
	var city: String = "",
	var address: String = "",
	var state: String = "",
)

data class CompanyInfoDto(
	var name: String? = "",
	var links: CompanyLinksDto? = CompanyLinksDto(),
	var hq: CompanyHeadQuarters? = CompanyHeadQuarters(),
	var coo: String? = "",
	var cto: String? = "",
	var ceo: String? = "",
	var cto_propulsion: String? = "",
	var employees: Int? = 0,
	var founded: String? = "",
	var founder: String? = "",
	var founded_at_y: Int? = 0,
	var founder_n: String? = "",
	var company_summary: String? = "",
	var company_valuation: Double? = 0.0,
)
