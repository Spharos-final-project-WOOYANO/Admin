package shparos.admin.presentation;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shparos.admin.application.AdminService;
import shparos.admin.application.CustomPageImpl;
import shparos.admin.dto.ClientListResponse;
import shparos.admin.global.common.response.BaseResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/client-list")
    public BaseResponse<?> getClientList(@PageableDefault Pageable pageable) {
        Page<ClientListResponse> clientList = adminService.getClientList(pageable);
        return new BaseResponse<>(clientList);
    }
}
