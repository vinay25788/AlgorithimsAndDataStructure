package datastructure.queue;

public class TourOnTruck {

    static class PetrolPump {
        int petrol;
        int distance;

        public PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    public static int printTour(PetrolPump[] petrolPumps, int n) {

        int start = 0;
        int end = 1;
        int curPetrol = petrolPumps[start].petrol - petrolPumps[start].distance;
        while (end != start || curPetrol < 0) {
            while (curPetrol < 0 && start != end) {
                curPetrol -= petrolPumps[start].petrol - petrolPumps[start].distance;
                start = (start + 1) % n;
                if (start == 0)
                    return -1;
            }
            curPetrol += petrolPumps[end].petrol - petrolPumps[end].distance;
            end = (end + 1) % n;
        }

        return start;

    }

    public static void main(String[] args) {

        PetrolPump[] arr = {new PetrolPump(6, 4),
                new PetrolPump(3, 6),
                new PetrolPump(7, 3)};

        int start = printTour(arr, arr.length);
        System.out.println(start == -1 ? " No Solution ": " solution will start from petrolpump "+start);
    }
}
