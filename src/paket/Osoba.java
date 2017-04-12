package paket;

public class Osoba {
	private String ime;
	private String prezime;
	private String sifra;
	public Osoba(String ime, String prezime, String sifra){
		this.ime=ime;
		this.prezime=prezime;
		this.sifra=sifra;
	}
	@Override
	public String toString() {
		return "Osoba [ime=" + ime + ", prezime=" + prezime + ", sifra=" + sifra + "]";
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
}
