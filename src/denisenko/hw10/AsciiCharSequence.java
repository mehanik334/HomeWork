package denisenko.hw10;

public class AsciiCharSequence implements CharSequence {


    private byte[] storageSymbol;

    public AsciiCharSequence() {
    }

    public AsciiCharSequence(byte[] storageSymbol) {
        this.storageSymbol = storageSymbol;
    }

    public byte[] getStorageSymbol() {
        return storageSymbol;
    }

    public void setStorageSymbol(byte[] storageSymbol) {
        this.storageSymbol = storageSymbol;
    }

    @Override
    public int length() {
        return storageSymbol.length;
    }

    @Override
    public char charAt(int index) {
        return (char) storageSymbol[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {

        CharSequence charSequence = new AsciiCharSequence();
        int sizeArr = end - start;
        byte[] ar = new byte[sizeArr];
        for (int i = start, j = 0; i <= end; i++, j++) {
            ar[j] = this.getStorageSymbol()[i];
        }

        ((AsciiCharSequence) charSequence).setStorageSymbol(ar);


        return charSequence;
    }
}
