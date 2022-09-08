package alg;

import alg.domains.ListNode;
import alg.domains.TreeNode;

import java.math.BigInteger;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.*;

public class MainFifth {
    public static void main(String[] args) throws ParseException {
        System.out.println(new MainFifth().convertTime("02:30", "04:35"));
    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        boolean hasIne = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int a = entry.getValue();
            while (a >= 2) {
                count += 2;
                a -= 2;
            }
            if (a == 1) {
                hasIne = true;
            }
        }
        if (hasIne) {
            count++;
        }
        return count;
    }

    public int findContentChildren(int[] g, int[] s) {
        int result = 0;
        int i = 0;
        int j = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                result++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return result;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            if ((i == 0 || (flowerbed[i - 1] != 1)) && (i == flowerbed.length - 1 || (flowerbed[i + 1] != 1))) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isValidPolin(s, left, right - 1) || isValidPolin(s, left + 1, right);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isValidPolin(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k > 0) {
                if (nums[i] < 0) {
                    sum += nums[i] * -1;
                    k--;
                } else if (nums[i] == 0) {
                    k = 0;
                } else {
                    if (k % 2 == 0) {
                        sum += nums[i];
                    } else {
                        if (i > 0 && nums[i - 1] * -1 < nums[i]) {
                            sum -= 2 * (nums[i - 1]) * -1;
                            sum += nums[i];
                        } else {
                            sum += nums[i] * -1;

                        }
                    }
                    k = 0;
                }
            } else {
                sum += nums[i];
            }

        }
        if (k > 0 && k % 2 != 0) {
            sum -= 2 * (nums[nums.length - 1]) * -1;
        }
        return sum;
    }

    public int convertTime(String current, String correct) throws ParseException {
        int timeCurrent = getMinutes(current);
        int timeCorrect = getMinutes(correct);
        int count = 0;
        while (timeCurrent != timeCorrect) {
            if (timeCurrent + 60 <= timeCorrect) {
                timeCurrent += 60;
            } else if (timeCurrent + 15 <= timeCorrect) {
                timeCurrent += 15;
            } else if (timeCurrent + 5 <= timeCorrect) {
                timeCurrent += 5;
            } else {
                timeCurrent += 1;
            }
            count++;
        }
        return count;
    }

    private int getMinutes(String current) {
        LocalTime time = LocalTime.parse(current);
        return time.getMinute() + (time.getHour() * 60);
    }

    public String removeDigit(String number, char digit) {
        char[] chars = number.toCharArray();
        int fromEnd = -1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == digit) {
                fromEnd = i;
                break;
            }
        }
        int fromStart = -1;
        for (int i = 0; i < chars.length; i--) {
            if (chars[i] == digit) {
                fromEnd = i;
                break;
            }
        }
        if (fromEnd != fromStart) {
            String first = new StringBuilder(number).deleteCharAt(fromStart).toString();
            String second = new StringBuilder(number).deleteCharAt(fromEnd).toString();
            if (new BigInteger(first).compareTo(new BigInteger(second)) > 0) {
                return first;
            } else {
                return second;
            }

        } else {
            return number.replaceFirst(String.valueOf(digit), "");
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> listList = new ArrayList<>();
        Arrays.sort(products);
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> strings = findAllWords(products, searchWord.substring(0, i));
            if (strings.isEmpty()) {
                break;
            } else {
                listList.add(strings);
            }
        }
        return listList;
    }

    private List<String> findAllWords(String[] products, String substring) {
        System.out.println(substring);
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < products.length; i++) {
            if (products[i].matches(substring + ".*")) {
                strings.add(products[i]);
            }
            if (strings.size() == 3) break;
        }
        return strings;
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        List<String> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map1.containsKey(list2[i])) {
                int current = map1.get(list2[i]) + i;
                if (current < min) {
                    list.clear();
                    list.add(list2[i]);
                    min = current;
                } else if (current == min) {
                    list.add(list2[i]);
                }
            }
        }
        return list.toArray(String[]::new);
    }

    public int findKthLargest(int[] nums, int k) {
        return kthSmallest(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    public static int partition(int[] arr, int low,
                                int high) {
        int pivot = arr[high], pivotloc = low;
        for (int i = low; i <= high; i++) {
            // inserting elements of less value
            // to the left of the pivot location
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[pivotloc];
                arr[pivotloc] = temp;
                pivotloc++;
            }
        }

        // swapping pivot to the final pivot location
        int temp = arr[high];
        arr[high] = arr[pivotloc];
        arr[pivotloc] = temp;

        return pivotloc;
    }

    // finds the kth position (of the sorted array)
    // in a given unsorted array i.e this function
    // can be used to find both kth largest and
    // kth smallest element in the array.
    // ASSUMPTION: all elements in arr[] are distinct
    public static int kthSmallest(int[] arr, int low,
                                  int high, int k) {
        // find the partition
        int partition = partition(arr, low, high);

        // if partition value is equal to the kth position,
        // return value at k.
        if (partition == k - 1)
            return arr[partition];

            // if partition value is less than kth position,
            // search right side of the array.
        else if (partition < k - 1)
            return kthSmallest(arr, partition + 1, high, k);

            // if partition value is more than kth position,
            // search left side of the array.
        else
            return kthSmallest(arr, low, partition - 1, k);
    }
    public int minPartitions(String n) {
        char max = 0;
        for (int i = 0; i < n.length(); i++) {
            if(n.charAt(i)>max){
                max = n.charAt(i);
            }
        }
        return Character.getNumericValue(max);
//        return subtract(n, 0);
    }

    public int subtract(String number, int result) {
        if (number.isEmpty()) return result;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != '0') {
                int res = Character.getNumericValue(number.charAt(i)) - 1;
                builder.append(res);
            } else {
                builder.append('0');
            }
        }
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == '0') {
                builder.deleteCharAt(i);
                i--;
            } else {
                break;
            }
        }
        return subtract(builder.toString(), result + 1);
    }





}
