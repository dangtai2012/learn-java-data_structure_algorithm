package Arrays;

public class StaticArray {
    // Mảng lưu dữ liệu
    private int[] arr;

    // Sức chứa tối đa của mảng
    private int capacity;

    // Số phần tử hiện tại trong mảng
    private int size;

    //region constructor
    public StaticArray(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.size = 0;
    }
    //endregion


    //region push

    /// Thêm phần tử vào cuối mảng
    public void push(int value) {
        // Kiểm tra số phần tử hiện tại (size) có >= sức chứa tối đa (capacity) hay không:
        // 1. Nếu >= thì quăng lỗi IllegalStateException
        if (this.size >= this.capacity) {
            throw new IllegalStateException("Array is full");
        }

        // Thêm value vào cuối arr bằng số phần tử hiện tại (size)
        // vì số phần tử hiện tại (size) cũng bằng index cuối của arr
        this.arr[this.size] = value;

        // Cộng 1 số phần tử hiện tại (size)
        this.size++;
    }
    //endregion

    //region pop

    /// Xóa và trả về phần tử cuối mảng
    public int pop() {
        // Kiểm tra số phần tử hiện tại (size) có <= 0 hay không:
        // 1. Nếu <= 0 thì quăng lỗi IllegalStateException
        if (this.size <= 0) {
            throw new IllegalStateException("Array is empty");
        }

        // Lưu giá trị cần return trước khi xoá
        int removedValue = this.arr[this.size - 1];

        // Xoá value cuối arr bằng số phần tử hiện tại (size)
        // vì số phần tử hiện tại (size) cũng bằng index cuối của arr
        this.arr[this.size - 1] = 0;

        // Trừ 1 số phần tử hiện tại (size)
        this.size--;

        // Trả về giá trị đã xoá
        return removedValue;
    }
    //endregion

    //region insert

    /// Thêm phần tử vào vị trí index
    public void insert(int index, int value) {
        // Kiểm tra số phần tử hiện tại (size) có >= sức chứa tối đa (capacity) hay không:
        // 1. Nếu >= thì quăng lỗi IllegalStateException
        if (this.size >= this.capacity) {
            throw new IllegalStateException("Array is full");
        }

        // Kiểm tra index có < 0 hoặc > số phần tử hiện tại trong mảng (size) hay không:
        // 1. Nếu có quăng lỗi IndexOutOfBoundsException
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        // Dời những số sau index về 1 index
        for (int i = this.size; i > index; i--) {
            this.arr[i] = this.arr[i - 1];
        }

        // Thêm value vào index yêu cầu
        this.arr[index] = value;

        // Cộng 1 số phần tử hiện tại (size)
        this.size++;

    }
    //endregion

    //region delete

    /// Xóa và trả về phần tử tại vị trí index
    public int delete(int index) {
        // Kiểm tra số phần tử hiện tại (size) có <= 0 hay không:
        // 1. Nếu <= 0 thì quăng lỗi IllegalStateException
        if (this.size <= 0) {
            throw new IllegalStateException("Array is empty");
        }

        // Kiểm tra index có < 0 hoặc >= số phần tử hiện tại trong mảng (size) hay không:
        // 1. Nếu có quăng lỗi IndexOutOfBoundsException
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        // Lưu giá trị cần return trước khi xoá
        int deletedValue = this.arr[index];

        // Dời những số sau index lên trước 1 index
        for (int i = index; i < this.size; i++) {
            this.arr[i] = this.arr[i + 1];
        }

        // Set value cuối của arr bằng 0
        this.arr[this.size - 1] = 0;

        // Trừ 1 số phần tử hiện tại (size)
        this.size--;

        // Trả về giá trị đã xoá
        return deletedValue;
    }
    //endregion

    //region get

    /// Lấy giá trị tại vị trí index
    public int get(int index) {
        // Kiểm tra index có < 0 hoặc > số phần tử hiện tại trong mảng (size) hay không:
        // 1. Nếu có quăng lỗi IndexOutOfBoundsException
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        // Trả về value cần get theo index
        return this.arr[index];
    }
    //endregion

    //region set

    /// Cập nhật giá trị tại vị trí index
    public void set(int index, int value) {
        // Kiểm tra index có < 0 hoặc > số phần tử hiện tại trong mảng (size) hay không:
        // 1. Nếu có quăng lỗi IndexOutOfBoundsException
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        // Set value mới theo index
        this.arr[index] = value;
    }
    //endregion

    //region size

    /// Lấy kích thước hiện tại của mảng
    public int size() {
        return this.size;
    }
    //endregion

    //region isEmpty

    /// Kiểm tra mảng có rỗng không
    public boolean isEmpty() {
        return this.size == 0;
    }
    //endregion

    //region isFull

    /// Kiểm tra mảng đã đầy chưa
    public boolean isFull() {
        return this.size == this.capacity;
    }
    //endregion

    //region print

    /// In ra tất cả phần tử trong arr
    public void print() {
        System.out.print("[");
        for (int i = 0; i < this.capacity; i++) {
            System.out.print(this.arr[i]);

            if (i >= this.size) {
                System.out.print("0");
            }

            if (i < this.capacity - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
    //endregion

}
