package Enum;

public enum TypeEnum {
	DIRECTEUR_HOTEL("Directeur de l�h�tel"),
	DIRECTEUR_RESTAURANT("Directeur du restaurant"),
	DIRECTEUR_HEBERGEUR("Directeur d�h�bergement"),
	DIRECTEUR_RECEPTION("Chef de r�ception"),
	DIRECTEUR_GENERALE("Gouvernante g�n�rale"),
	CHEF_MAINTENANCE("Chef de maintenance");
	
	private String text;

	TypeEnum(String text) {
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
	
	public static String fromEnum(TypeEnum TypeUtilisateur){
		for (TypeEnum b : TypeEnum.values()) {
			if (b==TypeUtilisateur) {
				return b.text;
			}
		}
		return null;
	}
	
	public static TypeEnum fromString(String text) {
		for (TypeEnum b : TypeEnum.values()) {
			if (b.text.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}
}
