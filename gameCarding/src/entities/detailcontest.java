package entities;

public class detailcontest {
	int id;
	int idcontest;
	int idplayer;
	int idpkm;
	int point;
	int rank;
	public detailcontest(int id, int idcontest, int idplayer, int idpkm, int point, int rank) {
		super();
		this.id = id;
		this.idcontest = idcontest;
		this.idplayer = idplayer;
		this.idpkm = idpkm;
		this.point = point;
		this.rank = rank;
	}
	public detailcontest(int idcontest, int idplayer, int idpkm, int point, int rank) {
		super();
		this.idcontest = idcontest;
		this.idplayer = idplayer;
		this.idpkm = idpkm;
		this.point = point;
		this.rank = rank;
	}
	public detailcontest() {
		super();
		this.id = 0;
		this.idcontest = 0;
		this.idplayer = 0;
		this.idpkm = 0;
		this.point = 0;
		this.rank = 0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdcontest() {
		return idcontest;
	}
	public void setIdcontest(int idcontest) {
		this.idcontest = idcontest;
	}
	public int getIdplayer() {
		return idplayer;
	}
	public void setIdplayer(int idplayer) {
		this.idplayer = idplayer;
	}
	public int getIdpkm() {
		return idpkm;
	}
	public void setIdpkm(int idpkm) {
		this.idpkm = idpkm;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
}
