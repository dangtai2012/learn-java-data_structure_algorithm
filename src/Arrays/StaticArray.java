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


    //region push - O(1)

    /// Thêm phần tử vào cuối mảng
    public void push(int value) {
        //TODO: Kiểm tra số phần tử hiện tại (size) có >= sức chứa tối đa (capacity) hay không:
        // 1. Nếu >= thì quăng lỗi IllegalStateException
        if (this.size >= this.capacity) {
            throw new IllegalStateException("Array is full");
        }

        //TODO: Thêm value vào cuối arr bằng số phần tử hiện tại (size)
        // vì số phần tử hiện tại (size) cũng bằng index cuối của arr
        this.arr[this.size] = value;

        //TODO: Cộng 1 số phần tử hiện tại (size)
        this.size++;
    }
    //endregion

    //region pop - O(1)

    /// Xóa và trả về phần tử cuối mảng
    public int pop() {
        //TODO: Kiểm tra số phần tử hiện tại (size) có <= 0 hay không:
        // 1. Nếu <= 0 thì quăng lỗi IllegalStateException
        if (this.size <= 0) {
            throw new IllegalStateException("Array is empty");
        }

        //TODO: Lưu giá trị cần return trước khi xoá
        int removedValue = this.arr[this.size - 1];

        //TODO: Xoá value cuối arr bằng số phần tử hiện tại (size)
        // vì số phần tử hiện tại (size) cũng bằng index cuối của arr
        this.arr[this.size - 1] = 0;

        //TODO: Trừ 1 số phần tử hiện tại (size)
        this.size--;

        //TODO: Trả về giá trị đã xoá
        return removedValue;
    }
    //endregion

    //region insert - O(n)

    /// Thêm phần tử vào vị trí index
    public void insert(int index, int value) {
        //TODO: Kiểm tra số phần tử hiện tại (size) có >= sức chứa tối đa (capacity) hay không:
        // 1. Nếu >= thì quăng lỗi IllegalStateException
        if (this.size >= this.capacity) {
            throw new IllegalStateException("Array is full");
        }

        //TODO: Kiểm tra index có < 0 hoặc > số phần tử hiện tại trong mảng (size) hay không:
        // 1. Nếu có quăng lỗi IndexOutOfBoundsException
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        //TODO: Dời những số sau index về 1 index
        for (int i = this.size; i > index; i--) {
            this.arr[i] = this.arr[i - 1];
        }

        //TODO: Thêm value vào index yêu cầu
        this.arr[index] = value;

        //TODO: Cộng 1 số phần tử hiện tại (size)
        this.size++;

    }
    //endregion

    //region delete - O(n)

    /// Xóa và trả về phần tử tại vị trí index
    public int delete(int index) {
        //TODO: Kiểm tra số phần tử hiện tại (size) có <= 0 hay không:
        // 1. Nếu <= 0 thì quăng lỗi IllegalStateException
        if (this.size <= 0) {
            throw new IllegalStateException("Array is empty");
        }

        //TODO: Kiểm tra index có < 0 hoặc >= số phần tử hiện tại trong mảng (size) hay không:
        // 1. Nếu có quăng lỗi IndexOutOfBoundsException
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        //TODO: Lưu giá trị cần return trước khi xoá
        int deletedValue = this.arr[index];

        //TODO: Dời những số sau index lên trước 1 index
        for (int i = index; i < this.size; i++) {
            this.arr[i] = this.arr[i + 1];
        }

        //TODO: Set value cuối của arr bằng 0
        this.arr[this.size - 1] = 0;

        //TODO: Trừ 1 số phần tử hiện tại (size)
        this.size--;

        //TODO: Trả về giá trị đã xoá
        return deletedValue;
    }
    //endregion

    //region get O(1)

    /// Lấy giá trị tại vị trí index
    public int get(int index) {
        //TODO: Kiểm tra index có < 0 hoặc > số phần tử hiện tại trong mảng (size) hay không:
        // 1. Nếu có quăng lỗi IndexOutOfBoundsException
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        //TODO: Trả về value cần get theo index
        return this.arr[index];
    }
    //endregion

    //region set - O(1)

    /// Cập nhật giá trị tại vị trí index
    public void set(int index, int value) {
        //TODO: Kiểm tra index có < 0 hoặc > số phần tử hiện tại trong mảng (size) hay không:
        // 1. Nếu có quăng lỗi IndexOutOfBoundsException
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        //TODO: Set value mới theo index
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

    //region clear - O(n)

    /// Xoá tất cả phần tử trong mảng
    public void clear() {
        // TODO: Set tất cả phần tử về 0
        for (int i = 0; i < this.size; i++) {
            this.arr[i] = 0;
        }

        // TODO: Reset size về 0
        this.size = 0;
    }
    //endregion

    //region contains - O(n)

    /// Kiểm tra giá trị có tồn tại trong mảng không
    public boolean contains(int value) {
        //TODO: Duyệt qua từng phần tử trong mảng và so sánh với value cần tìm
        // Trả về true nếu tìm thấy, false nếu không tìm thấy
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i] == value) {
                return true;
            }
        }

        return false;
    }
    //endregion

    //region indexOf - O(n)

    /// Tìm vị trí đầu tiên của giá trị trong mảng.
    /// Trả về -1 nếu không tìm thấy
    public int indexOf(int value) {
        //TODO: Duyệt qua từng phần tử trong mảng
        // So sánh với value cần tìm
        // Trả về index nếu tìm thấy
        // Trả về -1 nếu không tìm thấy
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i] == value) {
                return i;
            }
        }

        return -1;
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
