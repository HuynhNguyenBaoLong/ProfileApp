package com.example.profileapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Gọi hàm vẽ màn hình
            ProfileScreen()
        }
    }
}

@Composable
fun ProfileScreen() {
    val context = LocalContext.current // Dùng để hiển thị thông báo Toast

    // Column: Xếp các thành phần theo chiều dọc từ trên xuống dưới
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F9FA)) // Màu nền nhạt
            .padding(16.dp)
    ) {
        // Row: Xếp 2 nút bấm nằm ngang
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween // Đẩy 2 nút ra 2 góc
        ) {
            // Nút Quay lại
            IconButton(
                onClick = { Toast.makeText(context, "Bấm quay lại", Toast.LENGTH_SHORT).show() },
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.White, RoundedCornerShape(12.dp))
                    .border(1.dp, Color(0xFFE0E0E0), RoundedCornerShape(12.dp))
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color(0xFF333333))
            }

            // Nút Chỉnh sửa
            IconButton(
                onClick = { Toast.makeText(context, "Bấm chỉnh sửa", Toast.LENGTH_SHORT).show() },
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.White, RoundedCornerShape(12.dp))
                    .border(1.dp, Color(0xFFE0E0E0), RoundedCornerShape(12.dp))
            ) {
                Icon(Icons.Default.Edit, contentDescription = "Edit", tint = Color(0xFF0F766E))
            }
        }

        // Khoảng trống từ nút bấm xuống ảnh đại diện
        Spacer(modifier = Modifier.height(80.dp))

        // Ảnh đại diện bo tròn
        Image(
            painter = painterResource(id = R.drawable.profile_pic), // Tên file ảnh của bạn
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop, // Cắt ảnh cho vừa vặn
            modifier = Modifier
                .size(160.dp)
                .clip(CircleShape) // Lệnh bo tròn ảnh
                .align(Alignment.CenterHorizontally) // Căn giữa
        )

        // Khoảng trống từ ảnh xuống tên
        Spacer(modifier = Modifier.height(24.dp))

        // Tên
        Text(
            text = "Huynh Nguyen Bao Long",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Mã số sinh viên
        Text(
            text = "077205002692",
            fontSize = 18.sp,
            color = Color.Gray,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}