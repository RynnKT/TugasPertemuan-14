package pertemuan_14;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pertemuan_14.Booking;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-11-20T10:20:38", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Pelanggan.class)
public class Pelanggan_ { 

    public static volatile SingularAttribute<Pelanggan, String> nama;
    public static volatile SingularAttribute<Pelanggan, Integer> idPelanggan;
    public static volatile SingularAttribute<Pelanggan, String> noHp;
    public static volatile CollectionAttribute<Pelanggan, Booking> bookingCollection;
    public static volatile SingularAttribute<Pelanggan, String> email;

}