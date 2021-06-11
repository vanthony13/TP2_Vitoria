package app;

/**
 * Tem por finalidade, representar diferentes tipos de documento de identificação,
 *
 * @author Ruben Manuel Neves Martins
 * @version 1.0
 * @since 1.0
 *
 * @see Titular
 */
public class DocumentoID {
    private TipoDocumento TipDoc;
    private String codigo;

    public DocumentoID(String TipDoc, String codigo){
        this.TipDoc = gerarDoc(TipDoc);
        this.codigo = codigo;
    }

    private TipoDocumento gerarDoc(String TipDoc){
        TipoDocumento tipo = null;

        if (TipDoc.equalsIgnoreCase("BI")){
            tipo = TipoDocumento.BI;
        }
        if (TipDoc.equalsIgnoreCase("PASSAPORT")){
            tipo = TipoDocumento.PASSAPORT;
        }
        if (TipDoc.equalsIgnoreCase("TER")){
            tipo = TipoDocumento.TER;
        }
        if ((TipDoc.equalsIgnoreCase("CUC"))){
            tipo = TipoDocumento.CUC;
        }
        return tipo;
    }

    public TipoDocumento getTipDoc() {
        return TipDoc;
    }

    public void setTipDoc(TipoDocumento tipDoc) {
        TipDoc = tipDoc;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
