package controller;

import model.KnowledgeRepository;
import model.Putusan;
import util.InputHandler;

public class KnowledgeController {

    private KnowledgeRepository repository;

    public KnowledgeController() {
        this.repository = new KnowledgeRepository();
    }
    public boolean tambahPutusan(String[] rawData) {

        if (rawData == null || rawData.length < 12) {
            return false;
        }

        if (!InputHandler.isStringValid(rawData[0]) || !InputHandler.isStringValid(rawData[3])) {
            return false;
        }

        int umur = InputHandler.validasiInt(rawData[4]);
        double beratBB = InputHandler.validasiDouble(rawData[6]);
        int vonisHukuman = InputHandler.validasiInt(rawData[9]);
        double vonisDenda = InputHandler.validasiDouble(rawData[10]);

        if (umur == -1 || beratBB == -1.0 || vonisHukuman == -1 || vonisDenda == -1.0) {
            System.err.println("Gagal memproses data: Tipe data angka tidak valid.");
            return false;
        }

        if (!InputHandler.isPositive(beratBB) || !InputHandler.isPositive(vonisDenda)) {
            System.err.println("Gagal memproses data: Nilai angka tidak boleh minus.");
            return false;
        }

        Putusan putusanBaru = new Putusan(
                rawData[0], rawData[1], rawData[2], rawData[3],
                umur, rawData[5], beratBB, rawData[7],
                rawData[8], vonisHukuman, vonisDenda, rawData[11]
        );

        repository.simpan(putusanBaru);

        System.out.println("Data perkara " + rawData[0] + " berhasil diorkestrasi dan disimpan.");
        return true;
    }
}
