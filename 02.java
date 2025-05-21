class Vehicle {
    private String licensePlate;
    private String ownerName;
    private int hoursParked;

    public Vehicle(String licensePlate, String ownerName, int hoursParked) {
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
        this.hoursParked = hoursParked;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getHoursParked() {
        return hoursParked;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setHoursParked(int hoursParked) {
        this.hoursParked = hoursParked;
    }

    @Override
    public String toString() {
        return "License: " + licensePlate + ", Owner: " + ownerName + ", Hours: " + hoursParked;
    }
}

class ParkingLot {
    private Vehicle[] vehicles;
    private int count;

    public ParkingLot() {
        vehicles = new Vehicle[5]; // Maximum 5 vehicles
        count = 0;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (count < vehicles.length) {
            vehicles[count++] = vehicle;
            System.out.println("Vehicle parked: " + vehicle.getLicensePlate());
        } else {
            System.out.println("Parking lot is full!");
        }
    }

    public void removeVehicle(String licensePlate) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (vehicles[i].getLicensePlate().equalsIgnoreCase(licensePlate)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Vehicle with license " + licensePlate + " not found.");
            return;
        }

        System.out.println("Removing vehicle: " + vehicles[index].getLicensePlate());

        for (int i = index; i < count - 1; i++) {
            vehicles[i] = vehicles[i + 1];
        }

        vehicles[--count] = null;
    }

    public void displayAllVehicles() {
        if (count == 0) {
            System.out.println("Parking lot is empty.");
        } else {
            System.out.println("Vehicles in the parking lot:");
            for (int i = 0; i < count; i++) {
                System.out.println(vehicles[i]);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot();

        lot.parkVehicle(new Vehicle("ABC123", "John Doe", 2));
        lot.parkVehicle(new Vehicle("XYZ789", "Jane Smith", 4));
        lot.parkVehicle(new Vehicle("LNM456", "Bob Brown", 1));


        lot.removeVehicle("XYZ789");

        lot.displayAllVehicles();
    }
}
