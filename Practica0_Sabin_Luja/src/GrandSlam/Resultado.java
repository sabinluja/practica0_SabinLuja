package GrandSlam;

public class Resultado {
	
	private String anyo;
	private String torneo;
	private String ganador;
	private String rankingGanador;
	private String paisGanador;
	private String subcampeon;
	private String rankingSubcampeon;
	private String paisSubcampeon;
	private String resultadoFinal;
	
	public Resultado(String anyo, String torneo, String ganador, String rankingGanador, String paisGanador,
			String subcampeon, String rankingSubcampeon, String paisSubcampeon, String resultadoFinal) {

		this.anyo = anyo;
		this.torneo = torneo;
		this.ganador = ganador;
		this.rankingGanador = rankingGanador;
		this.paisGanador = paisGanador;
		this.subcampeon = subcampeon;
		this.rankingSubcampeon = rankingSubcampeon;
		this.paisSubcampeon = paisSubcampeon;
		this.resultadoFinal = resultadoFinal;
	}

	
	public Resultado() {}


	public String getAnyo() {
		return anyo;
	}

	public void setAnyo(String anyo) {
		this.anyo = anyo;
	}

	public String getTorneo() {
		return torneo;
	}

	public void setTorneo(String torneo) {
		this.torneo = torneo;
	}

	public String getGanador() {
		return ganador;
	}

	public void setGanador(String ganador) {
		this.ganador = ganador;
	}

	public String getRankingGanador() {
		return rankingGanador;
	}

	public void setRankingGanador(String rankingGanador) {
		this.rankingGanador = rankingGanador;
	}

	public String getPaisGanador() {
		return paisGanador;
	}

	public void setPaisGanador(String paisGanador) {
		this.paisGanador = paisGanador;
	}

	public String getSubcampeon() {
		return subcampeon;
	}

	public void setSubcampeon(String subcampeon) {
		this.subcampeon = subcampeon;
	}

	public String getRankingSubcampeon() {
		return rankingSubcampeon;
	}

	public void setRankingSubcampeon(String rankingSubcampeon) {
		this.rankingSubcampeon = rankingSubcampeon;
	}

	public String getPaisSubcampeon() {
		return paisSubcampeon;
	}

	public void setPaisSubcampeon(String paisSubcampeon) {
		this.paisSubcampeon = paisSubcampeon;
	}

	public String getResultadoFinal() {
		return resultadoFinal;
	}

	public void setResultadoFinal(String resultadoFinal) {
		this.resultadoFinal = resultadoFinal;
	}



	public String toString() {
		return "Resultado [anyo=" + anyo + ", torneo=" + torneo + ", ganador=" + ganador + ", rankingGanador="
				+ rankingGanador + ", paisGanador=" + paisGanador + ", subcampeon=" + subcampeon
				+ ", rankingSubcampeon=" + rankingSubcampeon + ", paisSubcampeon=" + paisSubcampeon
				+ ", resultadoFinal=" + resultadoFinal + "]";
	}
}
