package customer;

import music.CompactDisc;

public class CDCreator {
	
	movies.CompactDisc[] vcd; //phim
	
	music.CompactDisc[] cd; //nhac
	
	int nextMovie;
	int maxMovie;
	int nextAlbum;
	int maxAlbum;
	
	
	public CDCreator() {
		
		
		this.nextMovie = 0;
		this.maxMovie = 10;
		vcd = new movies.CompactDisc[this.maxMovie];
		
		this.nextAlbum = 0;
		this.maxAlbum = 2;
		cd = new music.CompactDisc[this.maxAlbum];
	}

	public CDCreator(movies.CompactDisc[] vcd, music.CompactDisc[] cd, int nextMovie, int maxMovie, int nextAlbum,
			int maxAlbum) {
		
		this.nextMovie = nextMovie;
		this.maxMovie = maxMovie;
		this.nextAlbum = nextAlbum;
		this.maxAlbum = maxAlbum;
		vcd = new movies.CompactDisc[this.maxMovie];
		cd = new music.CompactDisc[this.maxAlbum];
	}

	public void displayAllMusic() {
		if(this.nextAlbum>0) {
			for (int i = 0; i < nextAlbum; i++) {
				cd[i].xuat();
			}
		}
		else {
			System.out.println("Album chua co bai nao het!!!\n");
		}
		
	}
	
	public void displayAllMovie() {
		if(this.nextMovie>0) {
			for (int i = 0; i < nextMovie; i++) {
				vcd[i].xuat();
			}
		}
		else {
			System.out.println("Album chua co bo phim nao het!!!\n");
		}
		
	}
	
	public void addMusicCD() {
		if(this.nextAlbum<this.maxAlbum) {
			System.out.println("Nhap Music: ");			

//			music.CompactDisc a = new music.CompactDisc();
//			a.nhap();
//			cd[this.nextAlbum]= a;
			
			cd[this.nextAlbum] = new music.CompactDisc();
			cd[this.nextAlbum].nhap();
			System.out.println("Da them nhac thanh cong\n");
			this.nextAlbum++;
		}
		else{
			System.out.println("Album nhac da full, khong the them dc nua!!!\n");
		}
	}
	
	public void addMovieCD() {
		if(nextMovie<this.maxMovie) {
			System.out.println("Nhap Movie: ");
			movies.CompactDisc a = new movies.CompactDisc();
			a.nhap();
			vcd[this.nextMovie] = a;
			
//			vcd[this.nextAlbum] = new movies.CompactDisc();
//			vcd[this.nextAlbum].nhap();
			
			System.out.println("Da them phim thanh cong\n");
			this.nextMovie++;
		}
		else{
			System.out.println("Album phim da full, khong the them dc nua!!!\n");
		}
	}
	
	public static void main(String[] args) {
		
	}

}