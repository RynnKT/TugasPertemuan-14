package pertemuan_14;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pertemuan_14.Pelanggan;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-11-20T10:20:38", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Booking.class)
public class Booking_ { 

    public static volatile SingularAttribute<Booking, Integer> idBooking;
    public static volatile SingularAttribute<Booking, String> lapangan;
    public static volatile SingularAttribute<Booking, Pelanggan> idPelanggan;
    public static volatile SingularAttribute<Booking, String> tanggal;
    public static volatile SingularAttribute<Booking, String> status;

}