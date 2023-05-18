package util;

public class ConversorBytes {
    private static final long KIBI = 1L << 10;
    private static final long MEBI = 1L << 20;
    private static final long GIBI = 1L << 30;
    private static final long TEBI = 1L << 40;
    private static final long PEBI = 1L << 50;
    private static final long EXBI = 1L << 60;
    
    private Double formatarUnidades(long valor, long prefixo) {
        return (double) valor / prefixo;
    }
    
    public Double formatarBytes(long bytes) {
        if (bytes == 1L) { // bytes
            return (double)bytes;
        } else if (bytes < KIBI) { // bytes
            return (double)bytes;
        } else if (bytes < MEBI) { // KiB
            return formatarUnidades(bytes, KIBI);
        } else if (bytes < GIBI) { // MiB
            return formatarUnidades(bytes, MEBI);
        } else if (bytes < TEBI) { // GiB
            return formatarUnidades(bytes, GIBI);
        } else if (bytes < PEBI) { // TiB
            return formatarUnidades(bytes, TEBI);
        } else if (bytes < EXBI) { // PiB
            return formatarUnidades(bytes, PEBI);
        } else { // EiB
            return formatarUnidades(bytes, EXBI);
        }
        
    }
}
